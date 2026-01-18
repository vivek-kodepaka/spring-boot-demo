package com.kode.springBootEx.security.service;

import com.kode.springBootEx.security.entity.UserEntity;
import com.kode.springBootEx.security.model.User;
import com.kode.springBootEx.security.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final  UserRepo userRepo;

    public User registerUser(User user){
        User user1 = new User();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
       BeanUtils.copyProperties(
               userRepo.save(
                       UserEntity.builder()
                               .userName(user.getUserName())
                               .password(bCryptPasswordEncoder.encode(user.getPassword())).build())
               ,user1);
    return user1;
    }
}
