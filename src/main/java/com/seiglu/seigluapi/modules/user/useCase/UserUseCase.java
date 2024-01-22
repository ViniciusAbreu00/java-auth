package com.seiglu.seigluapi.modules.user.useCase;

import com.seiglu.seigluapi.exceptions.UserFoundException;
import com.seiglu.seigluapi.modules.user.UserEntity;
import com.seiglu.seigluapi.modules.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserUseCase {
    @Autowired
     private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserEntity createUser(UserEntity userEntity) {
        var alreadyExist = this.userRepository.findByEmail(userEntity.getEmail()).isPresent();
        var encondedPassword = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(encondedPassword);
        if(alreadyExist) {
            throw new UserFoundException();
        }

        return this.userRepository.save(userEntity);
    }


}
