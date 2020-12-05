package com.sda.onlinestore.repository;

import com.sda.onlinestore.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, String> {
}
