package com.sda.onlinestore.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MVCRoleController {

    @GetMapping("/viewRole")
    public String viewRole(){
        return "role-list";
    }
}
