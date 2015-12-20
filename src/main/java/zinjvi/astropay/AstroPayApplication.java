package zinjvi.astropay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MongoConfig.class, CxfConfiguration.class})
public class AstroPayApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AstroPayApplication.class, args);
    }
}
