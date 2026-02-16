package com.neo.learnspringboot.notes.reposotiry;

import com.neo.learnspringboot.notes.model.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    List<NoteEntity> findByStudyIdOrderByCreatedAtDesc(Long studyId);

    List<NoteEntity> findByStudyIdAndUserId(Long studyId, Long userId);

    boolean existsByIdAndUserId(Long noteId, Long userId);

}
