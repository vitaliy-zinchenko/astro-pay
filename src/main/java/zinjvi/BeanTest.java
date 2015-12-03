package zinjvi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

/**
 * Created by Vitaliy on 12/1/2015.
 */
@Service
public class BeanTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CityDao cityDao;

    @PostConstruct
    public void test() {

        cityDao.save();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

}
