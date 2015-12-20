package zinjvi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zinjvi.astropay.AstroPayApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AstroPayApplication.class)
@WebAppConfiguration
public class AstroPayApplicationTests {

	@Test
	public void contextLoads() {
	}

}
