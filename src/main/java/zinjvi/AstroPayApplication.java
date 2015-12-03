package zinjvi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MongoConfig.class, CxfConfiguration.class})
public class AstroPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AstroPayApplication.class, args);
    }
}
