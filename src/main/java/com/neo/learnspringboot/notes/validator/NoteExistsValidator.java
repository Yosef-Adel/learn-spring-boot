package com.neo.learnspringboot.notes.validator;

import com.neo.learnspringboot.notes.exception.NotFoundException;
import com.neo.learnspringboot.notes.reposotiry.NoteRepository;
import com.neo.learnspringboot.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class NoteExistsValidator extends Validator<Long> {
   private final NoteRepository noteRepository;

    @Override
    public boolean check(Long noteId) {
        if(!noteRepository.existsById(noteId)){
            throw new NotFoundException("Note with Id " + noteId +" not found");
        }

        return checkNext(noteId);
    }

}
