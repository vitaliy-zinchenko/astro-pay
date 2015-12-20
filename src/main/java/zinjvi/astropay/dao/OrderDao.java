package zinjvi.astropay.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zinjvi.astropay.model.Order;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Repository
public class OrderDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Order order) {
        entityManager.persist(order);
    }

    public List<Order> findAll() {
        return entityManager.createQuery("select o from Order o").getResultList();
    }

    public Order find(Long id) {
        return entityManager.find(Order.class, id);
    }

}
