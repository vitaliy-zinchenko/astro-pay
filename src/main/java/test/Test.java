package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import zinjvi.model.Order;

import java.text.NumberFormat;

/**
 * Created by Vitaliy on 11/28/2015.
 */
public class Test {
    public static void main1(String[] args) throws JsonProcessingException {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        Double price = new Double(1);
        System.out.println(price);
        String f = numberFormat.format(price);
        System.out.println(f);

        Order order = new Order();
//        order.setAmount(1d);

        ObjectMapper objectMapper = new ObjectMapper();
        String os = objectMapper.writeValueAsString(order);
        System.out.println(os);


    }
}
