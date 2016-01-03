package zinjvi.astropay.model.auth;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by Vitaliy on 12/22/2015.
 */
@Entity
@Table(name = "ap_auth_user")
public class AuthUser implements org.springframework.security.core.userdetails.UserDetails {

    @Id
    private Long id;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ap_auth_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<AuthRole> authRoles;

    @Override
    public Collection<AuthRole> getAuthorities() {
        return authRoles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AuthRole> getAuthRoles() {
        return authRoles;
    }

    public void setAuthRoles(List<AuthRole> authRoles) {
        this.authRoles = authRoles;
    }
}
