package zinjvi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zinjvi.service.OrderService;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * Created by Vitaliy on 11/27/2015.
 */
@Controller
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/main")
    public String main(Model model) {
        return "main";
    }




}
