package zinjvi.astropay.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zinjvi.astropay.model.order.StatusType;
import zinjvi.astropay.model.order.StatusTypeEnum;

import javax.persistence.EntityManager;
import javax.persistence.Id;

/**
 * Created by Vitaliy on 1/5/2016.
 */
@Repository
public class StatusTypeDao {

    @Autowired
    private EntityManager entityManager;

    public StatusType findStatusType(StatusTypeEnum statusTypeEnum) {
        return (StatusType) entityManager.createQuery("select st from StatusType st where st.type = :type")
                .setParameter("type", statusTypeEnum)
                .getSingleResult();
    }


}
