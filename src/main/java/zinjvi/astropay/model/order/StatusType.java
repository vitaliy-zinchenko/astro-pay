package zinjvi.astropay.model.order;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by Vitaliy on 1/4/2016.
 */
@Entity
@Table(name = "ap_ord_status_type",
        uniqueConstraints = {@UniqueConstraint(columnNames = "type")}
)
public class StatusType {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusTypeEnum type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusTypeEnum getType() {
        return type;
    }

    public void setType(StatusTypeEnum type) {
        this.type = type;
    }
}
