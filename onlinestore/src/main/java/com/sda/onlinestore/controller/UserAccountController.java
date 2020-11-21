package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.UserAccountDto;
import com.sda.onlinestore.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/api/addUserAccount")
    public ResponseEntity addUserAccount(@RequestBody UserAccountDto userAccountDto){
        userAccountService.addUserAccount(userAccountDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/api/getUserAccounts")
    public ResponseEntity getUserAccounts(){
        List<UserAccountDto> userAccountDtoList = userAccountService.getUserAccounts();
        return ResponseEntity.ok(userAccountDtoList);
    }
}
