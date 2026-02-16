package com.neo.learnspringboot.notes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoteRequestDTO {
    private  Long studyId;
    private String title;
    private String content;
}
