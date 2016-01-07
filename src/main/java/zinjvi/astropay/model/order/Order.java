package zinjvi.astropay.model.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import zinjvi.astropay.model.Merchant;
import zinjvi.astropay.model.Product;
import zinjvi.astropay.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Entity
@Table(name = "ap_ord_order")
public class Order {

    public static final String ORDER_ID_GENERATOR = "order_id_generator";

    @Id
    @GeneratedValue(generator = ORDER_ID_GENERATOR, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = ORDER_ID_GENERATOR, sequenceName = ORDER_ID_GENERATOR)
    private Long orderId;

    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "ap_ord_order_product",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "order")
    @org.codehaus.jackson.annotate.JsonBackReference
    private List<Status> statuses = new ArrayList<>();

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getAmount() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public void addStatus(Status status) {
        status.setOrder(this);
        this.statuses.add(status);
    }
}
