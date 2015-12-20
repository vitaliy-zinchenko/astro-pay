package zinjvi.astropay.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zinjvi.astropay.dao.UserDao;

/**
 * Created by Vitaliy on 12/4/2015.
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/list")
    public String get(Model model) {
        model.addAttribute("users", userDao.findAll());
        return "admin/user/list";
    }

    @RequestMapping("/info/{id}")
    public String save(@PathVariable Long id, Model model) {
        model.addAttribute("user", userDao.find(id));
        return "admin/user/info";
    }

}
