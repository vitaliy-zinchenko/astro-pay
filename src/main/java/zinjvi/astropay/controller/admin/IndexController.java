package zinjvi.astropay.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vitaliy on 12/4/2015.
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

    @RequestMapping
    public String get(Model model) {
        return "admin/index";
    }

}
