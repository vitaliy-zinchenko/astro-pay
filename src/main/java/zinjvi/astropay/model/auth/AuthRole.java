package zinjvi.astropay.model.auth;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by Vitaliy on 12/22/2015.
 */
@Entity
@Table(name = "ap_auth_role_type")
public class AuthRole implements GrantedAuthority {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType type;

    @Override
    public String getAuthority() {
        return type.name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }

}
