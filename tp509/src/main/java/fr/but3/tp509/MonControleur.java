package fr.but3.tp509;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

import org.springframework.ui.Model;

@Controller
public class MonControleur {
    @Autowired
    private JdbcUserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @GetMapping("/creer")
    @ResponseBody
    // example: http://localhost:8080/creer?login=foo&mdp=bar
    public String creerUtilisateur(@RequestParam String login, @RequestParam String mdp) {
//        get current user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "You are not allowed to create a user!";
        }

        if (userDetailsManager.userExists(login)) {
            return "User already exists!";
        }
        UserDetails user = User.withUsername(login)
                .password(passwordEncoder.encode(mdp))
                .roles("ROLE_USER")
                .build();
        userDetailsManager.createUser(user);
        return "User created successfully!";
    }
}