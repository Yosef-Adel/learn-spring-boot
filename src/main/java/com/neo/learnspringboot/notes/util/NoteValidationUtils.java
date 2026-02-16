package com.neo.learnspringboot.notes.util;

import com.neo.learnspringboot.notes.validator.NoteExistsValidator;
import com.neo.learnspringboot.notes.validator.NoteOwnerValidator;
import com.neo.learnspringboot.util.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NoteValidationUtils {
    private final NoteExistsValidator noteExistsValidator;
    private final NoteOwnerValidator noteOwnerValidator;

    public Validator<Long> constructDeleteValidator() {
        noteExistsValidator.chain(noteOwnerValidator);
        return noteExistsValidator;
    }
}
