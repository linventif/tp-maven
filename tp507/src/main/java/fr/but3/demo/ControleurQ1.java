package fr.but3.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class ControleurQ1 {
  @RequestMapping({ "/hello", "/" })
  // @ResponseBody
  public String hello() {
    return "mavue";
  }
}