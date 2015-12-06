package zinjvi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zinjvi.model.Product;
import zinjvi.model.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Repository
public class UserDao {

    @Autowired
    private EntityManager entityManager;

    public List<User> findAll() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    public User find(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }


}
