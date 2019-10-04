package ca.lclbootcamp.webapp1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @GetMapping("/greet")
    public String greet(@ApiIgnore @RequestHeader(required = false) String username) {
        System.out.println("User: " + username);
        return "App 1 says: Hello world!";
    }

    @GetMapping("/secret")
    public String secret() {
        return "App 2 says: secret";
    }
}
