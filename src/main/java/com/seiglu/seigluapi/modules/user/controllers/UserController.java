package com.seiglu.seigluapi.modules.user.controllers;

import com.seiglu.seigluapi.exceptions.UserFoundException;
import com.seiglu.seigluapi.modules.user.UserEntity;
import com.seiglu.seigluapi.modules.user.UserRepository;
import com.seiglu.seigluapi.modules.user.dto.UserAuthDTO;
import com.seiglu.seigluapi.modules.user.useCase.UserAuthUseCade;
import com.seiglu.seigluapi.modules.user.useCase.UserUseCase;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserUseCase userUseCase;
    @Autowired
    private UserAuthUseCade userAuthUseCade;
    @PostMapping("")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserEntity userEntity ) {
        try {
            var user =  this.userUseCase.createUser(userEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody UserAuthDTO userAuthDTO) {
        try {
            var token = userAuthUseCade.login(userAuthDTO);
            return ResponseEntity.status(HttpStatus.OK).body(token);
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }

    }

    @GetMapping("")
    public String getUser() {
      return "Seu usuário";
    };

    @GetMapping("{id}")
    public String getUserByID (@PathVariable String id) {
        return "Usuário " + id + " encontrado";
    };

    @GetMapping("byParams")
    public String getUserByParams(@RequestParam String id) {
        return "Usuário " + id + " por parametro encontrado";
    }
    @GetMapping("byMultipleParams")
    public String getUserByMultipleParams2(@RequestParam Map<String, String> allParams) {
        return "Usuário " + allParams.entrySet() + " por parametro encontrado";
    }

    @PostMapping("validateHeaders")
    public String validatePostHeaders(@RequestHeader("name") String name){
        return "Nome do seu header " + name;
    };

    @GetMapping("responseEntityTest")
    public ResponseEntity<Object> responseEntity() {
        return  ResponseEntity.status(200).body("Response entity");
    };

}
