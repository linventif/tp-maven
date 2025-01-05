package fr.but3.tp509;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/principal")
    @ResponseBody // need to be added because the return type is not a view name and the Controller is not a
    // RestController (rest does not need a view name)
    public Principal principal(Principal principal) {
        return principal;
    }
}