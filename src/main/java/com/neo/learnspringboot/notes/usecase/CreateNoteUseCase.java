package com.neo.learnspringboot.notes.usecase;

import com.neo.learnspringboot.notes.model.dto.CreateNoteRequestDTO;
import com.neo.learnspringboot.notes.model.dto.NoteDTO;
import com.neo.learnspringboot.notes.model.entity.NoteEntity;

public interface CreateNoteUseCase {

    NoteDTO create(CreateNoteRequestDTO note);
}
