package com.neo.learnspringboot.notes.service;

import com.neo.learnspringboot.notes.model.entity.NoteEntity;

import java.util.List;

public interface NoteService {
    NoteEntity create(NoteEntity note);
    NoteEntity getById(Long id);
    List<NoteEntity> getByStudyId(Long studyId);
    List<NoteEntity> getAll();
    NoteEntity update(Long id, String title, String content);
    void delete(Long id);
}
