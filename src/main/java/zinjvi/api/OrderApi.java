package zinjvi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zinjvi.model.OrderResponse;
import zinjvi.model.User;
import zinjvi.service.OrderResponseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * Created by Vitaliy on 11/28/2015.
 */
@Component
@Provider
@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
public class OrderApi {

    @Autowired
    private OrderResponseService orderResponseService;

    @POST
    @Path("/generate/{productCode}")
    public OrderResponse generate(
            @PathParam("productCode") String productCode,
            @BeanParam User user) throws GeneralSecurityException, UnsupportedEncodingException {
        return orderResponseService.createOrderResponse(productCode, user);
    }

}
