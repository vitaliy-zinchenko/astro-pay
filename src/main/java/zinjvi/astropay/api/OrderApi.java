package zinjvi.astropay.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zinjvi.astropay.service.OrderResponseService;
import zinjvi.astropay.model.User;
import zinjvi.astropay.dto.OrderResponse;
import zinjvi.messenger.api.rest.EmailProvider;

import javax.annotation.Resource;
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

    @Resource(name = "emailProvider")
    private EmailProvider emailProvider;

    @Autowired
    private OrderResponseService orderResponseService;

    @POST
    @Path("/generate/{productId}")
    public OrderResponse generate(
            @PathParam("productId") Long productId,
            @BeanParam User user) throws GeneralSecurityException, UnsupportedEncodingException {
        return orderResponseService.createOrderResponse(productId, user);
    }

}
