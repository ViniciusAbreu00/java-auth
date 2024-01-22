package com.seiglu.seigluapi.modules.therapist.controller;

import com.seiglu.seigluapi.modules.therapist.TherapistEntity;
import com.seiglu.seigluapi.modules.therapist.useCase.TherapistUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("therapist")
public class TherapistController {
    @Autowired
    private TherapistUseCase therapistUseCase;
    @PostMapping("")
    public ResponseEntity<Object> createTherapist(@Valid @RequestBody TherapistEntity therapistEntity) {
        try {
            var therapist = this.therapistUseCase.createTherapist(therapistEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(therapist);
        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }

}
