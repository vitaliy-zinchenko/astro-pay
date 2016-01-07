package zinjvi.astropay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zinjvi.astropay.dao.MerchantDao;
import zinjvi.astropay.dao.OrderDao;
import zinjvi.astropay.dao.ProductDao;
import zinjvi.astropay.dao.StatusTypeDao;
import zinjvi.astropay.dao.UserDao;
import zinjvi.astropay.model.order.Order;
import zinjvi.astropay.model.User;
import zinjvi.astropay.model.order.Status;
import zinjvi.astropay.model.order.StatusTypeEnum;

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
    @Autowired
    private StatusTypeDao statusTypeDao;
    @Autowired
    private OrderEmailService orderEmailService;

    public Order generate(Long productId, User user) {
        Order order = new Order();
        order.setOrderDate(new Date());
        userDao.save(user);//TODO remove
        order.setUser(user);
        order.setMerchant(merchantDao.findActiveMerchant());
        order.setProducts(Arrays.asList(productDao.find(productId)));
        order.addStatus(createStatus(StatusTypeEnum.OPEN));
        orderDao.save(order);
        return order;
    }

    private Status createStatus(StatusTypeEnum statusType) {
        Status status = new Status();
        status.setStatusType(statusTypeDao.findStatusType(statusType));
        return status;
    }

    @Transactional
    public void markOrderAsPayed(Long orderId) {
        Order order = orderDao.find(orderId);
        order.addStatus(createStatus(StatusTypeEnum.PAYED));
        orderEmailService.sendPayedNotification(order);
    }

    @Transactional
    public void changeOrderStatus(Long orderId, StatusTypeEnum statusType) {

    }

    public List<Order> findAll() {
        return orderDao.findAll();
    }

}
