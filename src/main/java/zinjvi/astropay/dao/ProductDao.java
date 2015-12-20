package zinjvi.astropay.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zinjvi.astropay.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Repository
public class ProductDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }

    public List<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    public Product find(Long id) {
        return entityManager.find(Product.class, id);
    }

    public Product findByProductCode(String productCode) {
        return (Product) entityManager
                .createQuery("select p from Product p where p.code = :productCode")
                .setParameter("productCode", productCode)
                .getSingleResult();
    }

}
