package zinjvi.astropay.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zinjvi.astropay.model.Merchant;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Repository
public class MerchantDao {

    @Autowired
    private EntityManager entityManager;

    public List<Merchant> findAll() {
        return entityManager.createQuery("select m from Merchant m").getResultList();
    }

    @Transactional
    public void save(Merchant merchant) {
        entityManager.persist(merchant);
    }

    public Merchant find(Long id) {
        return entityManager.find(Merchant.class, id);
    }

    public Merchant findActiveMerchant() {
        //TODO handle when no active and when them are two. and also use date to retrieve last active
        return (Merchant) entityManager.createQuery("select m from Merchant m where m.active = true").getSingleResult();
    }

}
