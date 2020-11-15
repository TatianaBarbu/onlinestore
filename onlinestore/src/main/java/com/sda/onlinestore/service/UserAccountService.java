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

    @Autowired
    private UserAccountTransformer userAccountTransformer;

    public void addUserAccount(UserAccountDto userAccountDto){
        UserAccount userAccount = userAccountTransformer.transform(userAccountDto);
        userAccountRepository.save(userAccount);
    }

    public List<UserAccountDto> getUserAccounts(){

        List<UserAccount> userAccounts = userAccountRepository.findAll();
        List<UserAccountDto> userAccountDtoList = new ArrayList<>();

        for(UserAccount userAccount : userAccounts){
            UserAccountDto userAccountDto = userAccountTransformer.transformReversed(userAccount);
            userAccountDtoList.add(userAccountDto);
        }
        return  userAccountDtoList;
    }


}
