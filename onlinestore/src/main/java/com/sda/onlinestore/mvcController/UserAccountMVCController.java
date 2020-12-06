package com.sda.onlinestore.mvcController;

import com.sda.onlinestore.dto.AddressDto;
import com.sda.onlinestore.dto.UserAccountDto;
import com.sda.onlinestore.entity.UserAccount;
import com.sda.onlinestore.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserAccountMVCController {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping(path = "/login")
    public String showLogin(){
        return "login";
    }

    @GetMapping(path = "/register")
    public String showRegisterForm(Model model){
        model.addAttribute("userRegister", new UserAccountDto());
        return "register";
    }

    @PostMapping(path = "/user/register")
    public String registerUser(@ModelAttribute("userRegister") UserAccountDto userAccountDto, BindingResult result){
        if(!userAccountDto.getPassword().equals(userAccountDto.getConfirmPassword())){
            result.rejectValue("password", null, "Passwords are not matching!");
            return "/register";
        }
        userAccountService.addUserAccount(userAccountDto);
        return "index";
    }

    @GetMapping("/viewUserAccounts")
    public String viewUserAccounts(){
        return "userAccount-list";
    }
}
