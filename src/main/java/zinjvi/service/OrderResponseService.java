package zinjvi.service;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zinjvi.model.Order;
import zinjvi.model.OrderResponse;
import zinjvi.model.Product;
import zinjvi.model.User;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Service
public class OrderResponseService {

    public static final String MERCHANT_SIGNATURE_DELIMITER = ";";
    public static final int PRODUCT_COUNT = 1;
    @Autowired
    private OrderService orderService;

    public OrderResponse createOrderResponse(String productCode, User user) throws GeneralSecurityException, UnsupportedEncodingException {
        OrderResponse orderResponse = new OrderResponse();
        Order order = orderService.generate(productCode, user);
        orderResponse.setOrder(order);
        orderResponse.setMerchantSignature(getMerchantSignature(order));
        return orderResponse;
    }

    private String getMerchantSignature(Order order) throws GeneralSecurityException, UnsupportedEncodingException {
        return ImmutableList.builder()
                .add(order.getMerchant().getAccount())
                .add(order.getMerchant().getDomainName())
                .add(order.getOrderId())
                .add(order.getOrderDate().getTime())
                .add(format(order.getAmount()))
                .add(order.getMerchant().getCurrency())
                .add(order.getProducts().stream().map(Product::getName).toArray())
                .add(PRODUCT_COUNT)
                .add(order.getProducts().stream().map(Product::getPrice).map(this::format).toArray())
                .build()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(MERCHANT_SIGNATURE_DELIMITER));
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
