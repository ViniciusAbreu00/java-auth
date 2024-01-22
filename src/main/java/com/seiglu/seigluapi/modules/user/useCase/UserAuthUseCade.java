package com.seiglu.seigluapi.modules.user.useCase;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.seiglu.seigluapi.exceptions.UserNotFoundException;
import com.seiglu.seigluapi.modules.user.UserRepository;
import com.seiglu.seigluapi.modules.user.dto.UserAuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class UserAuthUseCade {
    @Value("${security.token.secret}")
    private String secretKey;
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String login( UserAuthDTO userAuthDTO) throws AuthenticationException {
        var findUser = userRepository.findByEmail(userAuthDTO.getEmail());
        if(findUser.isEmpty()) {
            throw new UserNotFoundException();
        }
        var isMatchedPassword = passwordEncoder.matches(userAuthDTO.getPassword(), findUser.get().getPassword());
        if(!isMatchedPassword) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create().withIssuer("seiglu").withSubject(findUser.get().getId().toString()).sign(algorithm);
    }

}
