package zinjvi.astropay.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import zinjvi.astropay.model.order.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitaliy on 1/7/2016.
 */
@Service
public class OrderEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderEmailService.class);
    public static final String ORDER_PAYED_TEMPLATE_NAME = "order-payed.ftl";

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendPayedNotification(Order order) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("no-replay-astro@gmail.com");
        message.setTo("zinjvi@gmail.com");
        message.setSubject("payed");
        message.setText(generatePayedEmilBody(order));

        javaMailSender.send(message);
        LOG.debug("Payed notification sent successfully.");
    }

    private String generatePayedEmilBody(Order order) {
        Map data = new HashMap();
        data.put("order", order);
        return templateEngine.process(ORDER_PAYED_TEMPLATE_NAME, data);
    }

}
