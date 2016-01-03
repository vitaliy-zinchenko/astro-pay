package zinjvi.astropay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import zinjvi.astropay.dao.AuthUserDetailsDao;

/**
 * Created by Vitaliy on 12/21/2015.
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthUserDetailsDao authUserDetailsDao;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/pay", "/order", "/public", "/libs").permitAll()
                .antMatchers("/admin/**").fullyAuthenticated()
//                .anyRequest().denyAll()
                .and()
            .formLogin()
                //.successHandler() TODO
                .loginPage("/loginAdmin")
                .permitAll()

                .and()
            .logout()
                .permitAll()
            .and()
                .csrf()
                .disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authUserDetailsDao);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/pay", "/order").permitAll()
//                .antMatchers("/admin").authenticated()
////                .anyRequest().denyAll()
//                .and()
//            .formLogin()
//                .loginPage("/loginAdmin")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN");
//    }

}
