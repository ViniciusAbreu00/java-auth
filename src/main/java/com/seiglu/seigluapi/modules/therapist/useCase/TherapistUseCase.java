package com.seiglu.seigluapi.modules.therapist.useCase;

import com.seiglu.seigluapi.exceptions.TherapistFoundException;
import com.seiglu.seigluapi.modules.therapist.TherapistEntity;
import com.seiglu.seigluapi.modules.therapist.repository.TherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TherapistUseCase {
    @Autowired
    private TherapistRepository therapistRepository;
    public TherapistEntity createTherapist(TherapistEntity therapist) {
        var alreadyExist = this.therapistRepository.findByDocument(therapist.getDocument()).isPresent();
        if(alreadyExist) {
            throw new TherapistFoundException();
        }
        return this.therapistRepository.save(therapist);
    }

}
