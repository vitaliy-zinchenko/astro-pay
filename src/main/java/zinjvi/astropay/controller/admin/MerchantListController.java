package zinjvi.astropay.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zinjvi.astropay.dao.MerchantDao;
import zinjvi.astropay.model.Merchant;

/**
 * Created by Vitaliy on 12/4/2015.
 */
@Controller
@RequestMapping("/admin/merchant")
public class MerchantListController {

    @Autowired
    private MerchantDao merchantDao;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("merchants", merchantDao.findAll());
        return "admin/merchant/list";
    }

    @RequestMapping("/createForm")
    public String createForm(Model model) {
        return "admin/merchant/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Merchant merchant) {
        merchantDao.save(merchant);
        return "redirect:info/" + merchant.getMerchantId();
    }

    @RequestMapping(value = "/info/{id}")
    public String save(@PathVariable Long id, Model model) {
        model.addAttribute("merchant", merchantDao.find(id));
        return "admin/merchant/info";
    }

}
