package zinjvi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by Vitaliy on 11/28/2015.
 */
public class OrderResponse {

    private Order order;

    private String merchantSignature;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getMerchantSignature() {
        return merchantSignature;
    }

    public void setMerchantSignature(String merchantSignature) {
        this.merchantSignature = merchantSignature;
    }

}
