package zinjvi.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zinjvi.dao.ProductDao;
import zinjvi.model.Product;
import zinjvi.service.OrderService;

/**
 * Created by Vitaliy on 12/4/2015.
 */
@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/list")
    public String get(Model model) {
        model.addAttribute("products", productDao.findAll());
        return "admin/product/list";
    }

    @RequestMapping("/createForm")
    public String createForm() {
        return "admin/product/form";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute Product product) {
        productDao.save(product);
        return "redirect:info/" + product.getProductId();
    }

    @RequestMapping("/info/{id}")
    public String save(@PathVariable Long id, Model model) {
        model.addAttribute("product", productDao.find(id));
        return "admin/product/info";
    }

}
