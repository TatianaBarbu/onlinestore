package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.RoleDto;
import com.sda.onlinestore.entity.Role;
import com.sda.onlinestore.repository.RoleRepository;
import com.sda.onlinestore.transformers.RoleTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleTransformer roleTransformer;

    public void addRole(RoleDto roleDto) {
        Role role = roleTransformer.transform(roleDto);
        roleRepository.save(role);
    }

    public List<RoleDto> getRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDto> roleDtoList = new ArrayList<>();

        for (Role role : roles) {
            RoleDto roleDto = roleTransformer.transformReversed(role);
            roleDtoList.add(roleDto);
        }
        return roleDtoList;
    }
}
