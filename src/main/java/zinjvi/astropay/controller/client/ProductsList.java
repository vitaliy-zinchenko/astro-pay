package zinjvi.astropay.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zinjvi.astropay.dao.ProductDao;

/**
 * Created by Vitaliy on 1/3/2016.
 */
@Controller
@RequestMapping("/client/productsList")
public class ProductsList {

    @Autowired
    private ProductDao productDao;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", productDao.findAll());
        return "client/productsList";
    }

}
