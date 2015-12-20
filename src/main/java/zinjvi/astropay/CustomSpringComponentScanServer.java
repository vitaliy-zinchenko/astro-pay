package zinjvi.astropay;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.spring.SpringComponentScanServer;
import org.apache.cxf.jaxrs.spring.SpringResourceFactory;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vitaliy on 12/15/2015.
 */
public class CustomSpringComponentScanServer extends SpringComponentScanServer {

    protected void setRootResources(JAXRSServerFactoryBean factory) {
        boolean checkJaxrsRoots = checkJaxrsRoots();
        boolean checkJaxrsProviders = checkJaxrsProviders();

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            if("emailProvider".equals(beanName)) {
                continue;
            }
            if (!isInclude(beanName)) {
                continue;
            }
            if (checkJaxrsRoots && isAnnotationAvailable(beanName, Path.class)) {
                SpringResourceFactory resourceFactory = new SpringResourceFactory(beanName);
                resourceFactory.setApplicationContext(applicationContext);
                getResourceProviders().add(resourceFactory);
            } else if (checkJaxrsProviders && isAnnotationAvailable(beanName, Provider.class)) {
                getJaxrsProviders().add(applicationContext.getBean(beanName));
            }

        }

        factory.setResourceProviders(getResourceProviders());
    }

    private boolean isInclude(String beanName) {
        String className = applicationContext.getType(beanName).getName();
        for (String exclude : excludes()) {
            if (className.startsWith(exclude)) {
                return false;
            }
        }
        return true;
    }

    private List<String> excludes() {
        return Collections.singletonList("zinjvi.messenger.api.rest");
    }

}
