package com.neo.learnspringboot.notes.usecase.impl;

import com.neo.learnspringboot.notes.component.NoteMapper;
import com.neo.learnspringboot.notes.model.dto.CreateNoteRequestDTO;
import com.neo.learnspringboot.notes.model.dto.NoteDTO;
import com.neo.learnspringboot.notes.model.entity.NoteEntity;
import com.neo.learnspringboot.notes.service.NoteService;
import com.neo.learnspringboot.notes.usecase.CreateNoteUseCase;
import com.neo.learnspringboot.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateNoteUseCaseImpl implements CreateNoteUseCase {
    private  final NoteService noteService;
    private final UserService userService;
    private final NoteMapper noteMapper;

    @Override
    public NoteDTO create(CreateNoteRequestDTO note) {
        var user = userService.getDummyUser();
        var noteEntity = noteMapper.toEntity(note,user);

        var result = noteService.create(noteEntity);

        return noteMapper.toDTO(result);
    }
}
