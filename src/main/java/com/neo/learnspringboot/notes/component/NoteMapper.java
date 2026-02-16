package com.neo.learnspringboot.notes.component;

import com.neo.learnspringboot.notes.model.dto.CreateNoteRequestDTO;
import com.neo.learnspringboot.notes.model.dto.NoteDTO;
import com.neo.learnspringboot.notes.model.entity.NoteEntity;
import com.neo.learnspringboot.users.model.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class NoteMapper {
    public NoteDTO toDTO(NoteEntity entity) {
        return NoteDTO.builder()
                .id(entity.getId())
                .studyId(entity.getStudyId())
                .userId(entity.getUser().getId())
                .userEmail(entity.getUser().getEmail())
                .userFullName(entity.getUser().getFirstName() +" "+ entity.getUser().getLastName())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt()).build();
    }

    public List<NoteDTO> toDTOList(List<NoteEntity> entities) {
        return entities.stream()
                .map(this::toDTO)
                .toList();
    }

    public NoteEntity toEntity(CreateNoteRequestDTO request, UserEntity user) {
        NoteEntity note = new NoteEntity();
        note.setContent(request.getContent());
        note.setTitle(request.getTitle());
        note.setStudyId(request.getStudyId());
        note.setUser(user);
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());

        return  note;
    }
}
