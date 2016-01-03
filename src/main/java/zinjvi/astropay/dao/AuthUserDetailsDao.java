package zinjvi.astropay.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 * Created by Vitaliy on 12/22/2015.
 */
@Repository
public class AuthUserDetailsDao implements UserDetailsService {

    @Autowired
    private EntityManager entityManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return (UserDetails) entityManager
                    .createQuery("select au from AuthUser au where au.username = :username")
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            //TODO log
            throw new UsernameNotFoundException("Not user with username: " + username, e);
        }
    }
}
