package zinjvi.astropay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import zinjvi.astropay.model.Order;

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
