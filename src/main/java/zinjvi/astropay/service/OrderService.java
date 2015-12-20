package zinjvi.astropay.service;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zinjvi.astropay.dao.OrderDao;
import zinjvi.astropay.model.OrderResponse;
import zinjvi.astropay.model.order.Order;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.util.Date;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Service
public class OrderService {

    @Value("${app.pay.amount}")
    private Double orderAmount;
    @Value("${app.pay.key}")
    private String key;
    @Value("${app.pay.merchant-account}")
    private String merchantAccount;
    @Value("${app.pay.merchant-domain-name}")
    private String merchantDomainName;
    @Value("${app.pay.authorization-type}")
    private String authorizationType;
    @Value("${app.pay.currency}")
    private String currency;
    @Value("${app.pay.amount}")
    private String amount;
    @Value("${app.pay.product-name}")
    private String productName;
    @Value("${app.pay.product-count}")
    private Integer productCount;
    @Value("${app.pay.product-price}")
    private Double productPrice;

    @Autowired
    private OrderDao orderDao;

    public Order generate() {
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setAmount(orderAmount);
        orderDao.save(order);
        return order;
    }

    public OrderResponse createOrderResponse() throws GeneralSecurityException, UnsupportedEncodingException {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrder(generate());
        orderResponse.setMerchantAccount(merchantAccount);
        orderResponse.setMerchantDomainName(merchantDomainName);
        orderResponse.setAuthorizationType(authorizationType);
        orderResponse.setCurrency(currency);
        orderResponse.setProductName(productName);
        orderResponse.setProductCount(productCount);
        orderResponse.setProductPrice(productPrice);
        orderResponse.setMerchantSignature(getMerchantSignature(orderResponse));
        return orderResponse;
    }

    private String getMerchantSignature(OrderResponse orderResponse) throws GeneralSecurityException, UnsupportedEncodingException {
        StringBuilder fields = new StringBuilder();
        fields.append(orderResponse.getMerchantAccount())
                .append(";")
                .append(orderResponse.getMerchantDomainName())
                .append(";")
                .append(orderResponse.getOrder().getId())
                .append(";")
                .append(orderResponse.getOrder().getOrderDate().getTime())
                .append(";")
                .append(format(orderResponse.getOrder().getAmount()))
                .append(";")
                .append(orderResponse.getCurrency())
                .append(";")
                .append(orderResponse.getProductName())
                .append(";")
                .append(orderResponse.getProductCount())
                .append(";")
                .append(format(orderResponse.getProductPrice()));
        return computeSignature(fields.toString(), key);
    }

    private String format(Double aDouble) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        return numberFormat.format(aDouble);
    }

    private String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {

        SecretKey secretKey = null;

        byte[] keyBytes = keyString.getBytes("UTF-8");
        secretKey = new SecretKeySpec(keyBytes, "HmacMD5");

        Mac mac = Mac.getInstance("HmacMD5");

        mac.init(secretKey);

        byte[] text = baseString.getBytes("UTF-8");

        return new String(Hex.encodeHex(mac.doFinal(text))).trim();
    }

}
