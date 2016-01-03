package zinjvi.astropay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zinjvi.astropay.dao.ProductDao;

/**
 * Created by Vitaliy on 11/27/2015.
 */
@Controller
public class PayController {

    private static final Logger LOG = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/pay")
    public String main(Model model) {
        model.addAttribute("products", productDao.findAll());
        return "pay";
    }




}
