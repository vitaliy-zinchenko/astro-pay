package zinjvi.astropay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import zinjvi.astropay.model.order.Order;

/**
 * Created by Vitaliy on 11/28/2015.
 */
public class OrderResponse {

    private Order order;

    private String merchantAccount;

    private String merchantDomainName;

    private String authorizationType;

    private String currency;

    private Integer productCount;

    private String productName;

    @JsonFormat(pattern = "#.##", shape = JsonFormat.Shape.NUMBER_FLOAT)
    private Double productPrice;

    private String merchantSignature;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getMerchantDomainName() {
        return merchantDomainName;
    }

    public void setMerchantDomainName(String merchantDomainName) {
        this.merchantDomainName = merchantDomainName;
    }

    public String getAuthorizationType() {
        return authorizationType;
    }

    public void setAuthorizationType(String authorizationType) {
        this.authorizationType = authorizationType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getMerchantSignature() {
        return merchantSignature;
    }

    public void setMerchantSignature(String merchantSignature) {
        this.merchantSignature = merchantSignature;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
