package com.sda.onlinestore.mvcController;

import com.sda.onlinestore.dto.AddressDto;
import com.sda.onlinestore.dto.UserAccountDto;
import com.sda.onlinestore.entity.Role;
import com.sda.onlinestore.entity.UserAccount;
import com.sda.onlinestore.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserAccountMVCController {

    private final UserAccountService userAccountService;

    @Autowired
    public UserAccountMVCController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping(path = "/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping(path = "/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userRegister", new UserAccountDto());
        return "register";
    }

    @PostMapping(path = "/user/register")
    public String registerUser(@ModelAttribute("userRegister") @Valid UserAccountDto userAccountDto, BindingResult result) {
        Optional<UserAccount> optUserAccount = this.userAccountService.findUserAccountByUsername(userAccountDto.getUsername());
        if (optUserAccount.isPresent()) {
            result.rejectValue("username", null, "Username already exists.");
        }
        if (!userAccountDto.getPassword().equals(userAccountDto.getConfirmPassword())) {
            result.rejectValue("password", null, "Passwords are not matching!");
        }
        if (result.hasErrors()) {
            return "register";
        }
        userAccountService.addUserAccount(userAccountDto);
        return "index";
    }

    @GetMapping(path = "/viewUserAccounts")
    public String viewUserAccounts(Model model) {
        model.addAttribute("users", this.userAccountService.getUserAccounts());
        return "userAccount-list";
    }

    @GetMapping(path = "/userAccount/edit/{id}")
    public String showEditPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("userAccount", this.userAccountService.findUserAccountById(id));
        return "edit-userAccount";
    }

    @GetMapping(path = "/userAccount/delete/{id}")
    public String deleteUserAccountById(@PathVariable("id") Long id, Model model) {
        this.userAccountService.deleteUserAccountById(id);
        return "redirect:/viewUserAccounts";
    }

    @PostMapping(path = "/userAccount/update")
    public String editUserAccount(@ModelAttribute("userAccount") @Valid UserAccount userAccount, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-userAccount";
        }
        this.userAccountService.saveUserAccount(userAccount);
        return "redirect:/viewUserAccounts";
    }
}
