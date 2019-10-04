package ca.lclbootcamp.webapp2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @GetMapping("/greet")
    public String greet() {
        return "App 2 says: Hello world!";
    }
}
