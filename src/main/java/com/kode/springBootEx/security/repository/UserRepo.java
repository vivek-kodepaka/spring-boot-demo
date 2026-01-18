package com.kode.springBootEx.security.repository;

import com.kode.springBootEx.security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserName(String userName);
}
