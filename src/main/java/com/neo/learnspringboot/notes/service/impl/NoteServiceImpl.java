package com.neo.learnspringboot.notes.service.impl;

import com.neo.learnspringboot.notes.exception.NotFoundException;
import com.neo.learnspringboot.notes.model.entity.NoteEntity;
import com.neo.learnspringboot.notes.reposotiry.NoteRepository;
import com.neo.learnspringboot.notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;


    @Override
    public NoteEntity create(NoteEntity note) {
        return noteRepository.save(note);
    }

    @Override
    public NoteEntity getById(Long id) {
        return noteRepository.findById(id).orElseThrow(()-> new NotFoundException("Note with Id "+ id + " not found" ));
    }

    @Override
    public List<NoteEntity> getByStudyId(Long studyId) {
        return  noteRepository.findByStudyIdOrderByCreatedAtDesc(studyId);
    }

    @Override
    public List<NoteEntity> getAll() {
        return  noteRepository.findAll();
    }

    @Override
    public NoteEntity update(Long id, String title, String content) {
        NoteEntity note = noteRepository.findById(id).orElseThrow(()-> new NotFoundException("Note with Id "+ id + " not found" ));

        note.setTitle(title);
        note.setContent(content);
        note.setUpdatedAt(LocalDateTime.now());

        return  noteRepository.save(note);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
