package com.sda.onlinestore.service;


import com.sda.onlinestore.dto.UserAccountDto;
import com.sda.onlinestore.entity.UserAccount;
import com.sda.onlinestore.repository.UserAccountRepository;
import com.sda.onlinestore.transformers.UserAccountTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public void addUserAccount(UserAccountDto userAccountDto){
        UserAccountTransformer userAccountTransformer = new UserAccountTransformer();
        userAccountTransformer.transform(userAccountDto);
    }

    
}
