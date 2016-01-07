package zinjvi.astropay.dto;

import zinjvi.astropay.model.order.Order;

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
