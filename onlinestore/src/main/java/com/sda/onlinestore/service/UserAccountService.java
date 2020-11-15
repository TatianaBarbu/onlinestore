package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.UserAccountDTO;
import com.sda.onlinestore.entity.UserAccount;
import com.sda.onlinestore.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

}
