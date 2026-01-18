package com.kode.springBootEx.security.service;

import com.kode.springBootEx.security.entity.UserEntity;
import com.kode.springBootEx.security.model.UserDetailsImpl;
import com.kode.springBootEx.security.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepo.findByUserName(username);
        if(userEntity ==null){
            log.info("user {} not found",username);
            throw new UsernameNotFoundException("username: "+username+" not found");
        }
        return new UserDetailsImpl(userEntity);
    }
}
