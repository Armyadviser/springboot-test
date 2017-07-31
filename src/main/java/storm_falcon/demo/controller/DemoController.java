package storm_falcon.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gewp
 */
@RestController
@EnableAutoConfiguration
public class DemoController {

    @RequestMapping("/hello")
    public String index() {
        System.out.println("Hello");
        return "Hello World.";
    }
}
