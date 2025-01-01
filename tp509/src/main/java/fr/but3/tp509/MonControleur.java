package fr.but3.tp509;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import org.springframework.ui.Model;

@Controller
public class MonControleur {
    @GetMapping("/private")
    public String privatePage(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "private/v2";
    }

    @GetMapping("/public")
    public String publicPage(Model model) {
        model.addAttribute("username", "anonymous");
        return "public/v1";
    }
}