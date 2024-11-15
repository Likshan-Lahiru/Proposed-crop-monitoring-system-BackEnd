package Final.springBoot.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
public class ApplicationHealth {
    @GetMapping
    public String healthTest(){
        return "Backend request is working";
    }
}
