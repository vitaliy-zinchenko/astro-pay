package zinjvi.astropay.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zinjvi.astropay.service.OrderService;

/**
 * Created by Vitaliy on 12/4/2015.
 */
@Controller
@RequestMapping("/admin/order")
public class OrderListController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/list")
    public String get(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "admin/order/list";
    }

}
