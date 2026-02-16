package com.neo.learnspringboot.notes.api;

import com.neo.learnspringboot.notes.model.dto.CreateNoteRequestDTO;
import com.neo.learnspringboot.notes.model.dto.NoteDTO;
import com.neo.learnspringboot.notes.model.entity.NoteEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("api/v1/notes")
public interface NotesEndPoint {

    @GetMapping
    List<NoteDTO> getAllNotes();

    @GetMapping("/{id}")
    NoteDTO getNoteById();

    @PutMapping("/{id}")
    NoteDTO updateNote();

    @DeleteMapping("/{id}")
    void deleteNote(@PathVariable Long id);

    @PostMapping
    NoteDTO createNote(@RequestBody CreateNoteRequestDTO note);

    @GetMapping("/study/{studyId}")
    List<NoteDTO> getNotesByStudyId(@PathVariable Long studyId);
}
