package zinjvi.astropay.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Entity
@Table(name = "ap_order")
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
    @JoinTable(name = "ap_order_product",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

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
}
