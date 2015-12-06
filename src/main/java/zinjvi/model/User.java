package zinjvi.model;

import javax.persistence.*;
import javax.ws.rs.FormParam;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Entity
@Table(name = "ap_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @FormParam("userId")
    private Long userId;

    @FormParam("firstName")
    private String firstName;

    @FormParam("lastName")
    private String lastName;

    @FormParam("email")
    private String email;

    @FormParam("phone")
    private String phone;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
