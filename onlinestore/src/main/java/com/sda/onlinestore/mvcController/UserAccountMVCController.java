package com.sda.onlinestore.mvcController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAccountMVCController {

    @GetMapping("/viewUserAccounts")
    public String viewUserAccounts(){
        return "userAccount-list";
    }
}