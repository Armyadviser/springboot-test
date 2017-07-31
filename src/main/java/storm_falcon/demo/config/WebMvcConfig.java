package storm_falcon.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author gewp
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "storm_falcon.demo.controller")
public class WebMvcConfig {
}
