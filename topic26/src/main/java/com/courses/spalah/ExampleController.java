package com.courses.spalah;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ievgen Tararaka
 */
@Controller
public class ExampleController {

    @RequestMapping("/say_hello")
    public String hello(Model model) {
        return "jsp/hello";
    }

    @RequestMapping("/say_hello_body")
    @ResponseBody
    public String helloBody() {
        return "hello";
    }
}
