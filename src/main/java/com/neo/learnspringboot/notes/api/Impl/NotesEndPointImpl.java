package com.neo.learnspringboot.notes.api.Impl;

import com.neo.learnspringboot.notes.api.NotesEndPoint;
import com.neo.learnspringboot.notes.component.NoteMapper;
import com.neo.learnspringboot.notes.model.dto.CreateNoteRequestDTO;
import com.neo.learnspringboot.notes.model.dto.NoteDTO;
import com.neo.learnspringboot.notes.service.NoteService;
import com.neo.learnspringboot.notes.usecase.CreateNoteUseCase;
import com.neo.learnspringboot.notes.usecase.DeleteNoteUseCase;
import com.neo.learnspringboot.notes.util.NoteValidationUtils;
import com.neo.learnspringboot.util.Validator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class NotesEndPointImpl implements NotesEndPoint {
    private  final CreateNoteUseCase createNoteUseCase;
    private final DeleteNoteUseCase deleteNoteUseCase;
    private  final NoteValidationUtils noteValidationUtils;
    private  final NoteService noteService;
    private final NoteMapper noteMapper;

    @Override
    public List<NoteDTO> getAllNotes() {
        return noteMapper.toDTOList(noteService.getAll());
    }

    @Override
    public NoteDTO getNoteById() {
        return null;
    }

    @Override
    public NoteDTO updateNote() {
        return null;
    }

    @Override
    public void deleteNote(@PathVariable Long id) {
        Validator<Long> validator = noteValidationUtils.constructDeleteValidator();
        validator.check(id);
        deleteNoteUseCase.delete(id);
    }

    @Override
    public NoteDTO createNote(CreateNoteRequestDTO note) {
        return  createNoteUseCase.create(note);
    }

    @Override
    public List<NoteDTO> getNotesByStudyId(Long studyId) {
        return List.of();
    }
}
