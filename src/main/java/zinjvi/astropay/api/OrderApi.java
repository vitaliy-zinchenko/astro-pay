package zinjvi.astropay.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zinjvi.astropay.model.OrderResponse;
import zinjvi.messenger.api.rest.EmailProvider;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

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

    @GET
    @Path("/generate")
    public OrderResponse generate() {
        emailProvider.send("qwe");
        return new OrderResponse();
    }

}
