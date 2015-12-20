package zinjvi.astropay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zinjvi.astropay.dao.MerchantDao;
import zinjvi.astropay.dao.OrderDao;
import zinjvi.astropay.dao.ProductDao;
import zinjvi.astropay.dao.UserDao;
import zinjvi.astropay.model.Order;
import zinjvi.astropay.model.User;

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
