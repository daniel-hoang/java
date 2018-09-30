package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Convenient annotation adds:
 * - @Configuration tags this class as a source of bean def for "application context"
 * - @EnableAutoConfiguration adds beans based on classpath settings, beans, property settings
 * - @EnableMvc adds this annotation if spring-webmvc on the classpath
 * - @ComponentScan looks for other components, configs, services in this package to find controllers.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // Just run the application, don't have to deal with any configs or infrastructure!
        // From IDEA editor, just Ctrl-Shift-F10 in this file would run the application.
        // To test, from browser http://localhost:8080, you should see the index() served.
        SpringApplication.run(Application.class, args);
    }
}
