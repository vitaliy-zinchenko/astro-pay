package zinjvi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zinjvi.model.OrderResponse;
import zinjvi.service.OrderResponseService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    @GET
    @Path("/generate")
    public OrderResponse generate() throws GeneralSecurityException, UnsupportedEncodingException {
        return orderResponseService.createOrderResponse();
    }

}
