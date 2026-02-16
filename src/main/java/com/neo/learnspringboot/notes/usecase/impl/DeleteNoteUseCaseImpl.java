package com.neo.learnspringboot.notes.usecase.impl;

import com.neo.learnspringboot.notes.service.NoteService;
import com.neo.learnspringboot.notes.usecase.DeleteNoteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteNoteUseCaseImpl implements DeleteNoteUseCase {

    private final NoteService noteService;

    @Override
    public void delete(Long id) {
        noteService.delete(id);
    }
}
