package com.sda.onlinestore.restController;

import com.sda.onlinestore.dto.UserAccountDto;
import com.sda.onlinestore.entity.UserAccount;
import com.sda.onlinestore.service.UserAccountService;
import com.sda.onlinestore.transformers.UserAccountTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/userAccount")
@CrossOrigin(origins = "*")
@Controller
public class UserAccountController {

    private final UserAccountService userAccountService;

    private final UserAccountTransformer userAccountTransformer;

    @Autowired
    public UserAccountController(UserAccountService userAccountService, UserAccountTransformer userAccountTransformer){
        this.userAccountService = userAccountService;
        this.userAccountTransformer = userAccountTransformer;
    }

    //SOLVED
    @PostMapping("/api/createUserAccount")
    public ResponseEntity<UserAccountDto> createUserAccount(@RequestBody UserAccountDto userAccountDto){
        UserAccount userAccount = userAccountTransformer.transform(userAccountDto);
        UserAccount savedUserAccount = userAccountService.saveUserAccount(userAccount);
        UserAccountDto savedUserAccountDto = userAccountTransformer.transformReversed(savedUserAccount);
        return ResponseEntity.ok(userAccountDto);
    }

    //Just Check again
    @GetMapping("/api/getUserAccounts")
    public ResponseEntity<List<UserAccountDto>> getUserAccounts(){
        List<UserAccountDto> userAccountDtoList = userAccountService.getUserAccounts();
        return ResponseEntity.ok(userAccountDtoList);
    }

    //SOLVED
    @PutMapping("/api/updateUserAccount")
    public ResponseEntity<UserAccountDto> updateUserAccount(@RequestBody UserAccountDto userAccountDto) {
        UserAccount userAccount = userAccountTransformer.transform(userAccountDto);
        UserAccount savedUserAccount = userAccountService.saveUserAccount(userAccount);
        UserAccountDto savedUserAccountDto = userAccountTransformer.transformReversed(savedUserAccount);
        return ResponseEntity.ok(savedUserAccountDto);
    }

    //CHECK IT
    @DeleteMapping(path = "/{username}")
    public ResponseEntity<Void> deleteUserAccountByUsername(@PathVariable("username") String username) {
        userAccountService.deleteUserAccountByUsername(username);
        return ResponseEntity.noContent().build();
    }
}
