package zinjvi.astropay.service.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zinjvi.astropay.service.TemplateEngine;
import zinjvi.astropay.service.TemplateProcessingException;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Vitaliy on 1/7/2016.
 */
@Component
public class FreemarkerTemplateEngine implements TemplateEngine {

    private static final Logger LOG = LoggerFactory.getLogger(FreemarkerTemplateEngine.class);

    @Autowired
    private Configuration configuration;

    @Override
    public String process(String templateName, Object data) throws TemplateProcessingException {
        try {
            LOG.debug("Processing template {}.", templateName);
            Template template = configuration.getTemplate(templateName);
            StringWriter writer = new StringWriter();
            template.process(data, writer);
            String response = writer.toString();
            LOG.debug("Processed template {}. Result message is: \n {}", templateName, response);
            return response;
        } catch (IOException|TemplateException e) {
            throw new TemplateProcessingException("Fail processing template " + templateName, e);
        }
    }
}
