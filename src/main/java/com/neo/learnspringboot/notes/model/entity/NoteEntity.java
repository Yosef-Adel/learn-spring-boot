package com.neo.learnspringboot.notes.model.entity;

import com.neo.learnspringboot.users.model.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "NOTE")
@Getter @Setter @NoArgsConstructor
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studyId;
    private  String title;
    private  String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

}
