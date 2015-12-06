package zinjvi.service;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zinjvi.dao.MerchantDao;
import zinjvi.dao.OrderDao;
import zinjvi.dao.ProductDao;
import zinjvi.dao.UserDao;
import zinjvi.model.OrderResponse;
import zinjvi.model.Order;
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
import java.util.Date;
import java.util.List;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private MerchantDao merchantDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;

    public Order generate(String productCode, User user) {
        Order order = new Order();
        order.setOrderDate(new Date());
        userDao.save(user);//TODO remove
        order.setUser(user);
        order.setMerchant(merchantDao.findActiveMerchant());
        order.setProducts(Arrays.asList(productDao.findByProductCode(productCode)));
        orderDao.save(order);
        return order;
    }

    public List<Order> findAll() {
        return orderDao.findAll();
    }

}
