package zinjvi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import zinjvi.model.order.Order;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Repository
public class OrderDao {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Order order) {
        mongoOperations.save(order);
    }

}
