package zinjvi.astropay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Created by Vitaliy on 12/2/2015.
 */
@Repository
public class CityDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save() {
        City city = new City("aa");
        entityManager.persist(city);
    }

}
