package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.UserAccountDto;
import com.sda.onlinestore.dto.UserDto;
import com.sda.onlinestore.entity.Role;
import com.sda.onlinestore.entity.UserAccount;
import com.sda.onlinestore.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service("userService")
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> userCredentialModelOptional = userAccountRepository.findUserAccountByUsername(username);
        if (!userCredentialModelOptional.isPresent()) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        UserAccount userCredentialModel = userCredentialModelOptional.get();
        String userName = userCredentialModel.getUsername();
        String password = userCredentialModel.getPassword();
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        //ROLE_ADMIN is important to be picked up by hasRole from @PreAuthorize in DummyConteoller
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" +  userCredentialModel.getRole().getRoleName().toUpperCase());
        authorities.add(simpleGrantedAuthority);
        return new User(userName, password, authorities);
    }
    public UserAccount register(UserDto user) {
        UserAccount newUser = new UserAccount();
        newUser.setUsername(user.getUsername());
        Role role = new Role();
        role.setRoleName("USER");
        newUser.setRole(role);
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userAccountRepository.save(newUser);
    }

    public UserAccount saveUserDTO(UserAccountDto userAccountDto) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(userAccountDto.getUsername());
        userAccount.setPassword((bcryptEncoder.encode(userAccountDto.getPassword())));
        userAccount.getRole().setRoleName("" +
                "ROLE_USER");
        return userAccountRepository.save(userAccount);
    }

    @PostConstruct
    public void init() {
        List<User> users = new ArrayList<>();
        if(!userRepository.findByUsername("admin").isPresent()){
            users.add(new User("admin", encoder.encode("admin"), "ROLE_ADMIN"));
        }
        if(!userRepository.findByUsername("user").isPresent()){
            users.add(new User("user", encoder.encode("user"), "ROLE_USER"));
        }
        userRepository.saveAll(users);
    }
}
