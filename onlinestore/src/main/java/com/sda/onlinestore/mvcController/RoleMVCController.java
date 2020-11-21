package com.sda.onlinestore.mvcController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleMVCController {

    @GetMapping("/viewRole")
    public String viewRole(){
        return "role-list";
    }
}
