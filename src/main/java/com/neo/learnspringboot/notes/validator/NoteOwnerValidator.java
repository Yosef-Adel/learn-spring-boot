package com.neo.learnspringboot.notes.validator;

import com.neo.learnspringboot.notes.exception.ForbiddenException;
import com.neo.learnspringboot.notes.reposotiry.NoteRepository;
import com.neo.learnspringboot.users.service.UserService;
import com.neo.learnspringboot.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoteOwnerValidator extends Validator<Long> {

    private final NoteRepository noteRepository;
    private final UserService userService;


    @Override
    public boolean check(Long noteId) {
        // TODO: replace with SecurityUtils.getCurrentUser() later
        var currentUser = userService.getDummyUser();
        Long currentUserId = currentUser.getId();
        if (!noteRepository.existsByIdAndUserId(noteId, currentUserId)) {
            throw new ForbiddenException("You don't own this note");
        }
        return checkNext(noteId);
    }
}
