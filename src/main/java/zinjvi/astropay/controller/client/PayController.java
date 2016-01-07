package zinjvi.astropay.controller.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zinjvi.astropay.dao.ProductDao;
import zinjvi.astropay.service.OrderService;

/**
 * Created by Vitaliy on 11/27/2015.
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    private static final Logger LOG = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/{id}")
    public String pay(@PathVariable Long id, Model model) {
        model.addAttribute("productId", id);
        return "client/pay";
    }

    @RequestMapping("/successful/{orderId}")
    public String successful(@PathVariable Long orderId) {
        orderService.markOrderAsPayed(orderId);
        return "client/successful";
    }

}
