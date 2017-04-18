package com.skywind.service;

import com.skywind.model.Comment;
import com.skywind.dto.CommentDto;

import java.util.List;

/**
 * Created by Rost on 17.04.2017.
 */
public interface CommentService {
    List<Comment> getAll();
    List<Comment> getAll(int offset, int limit);
    CommentDto save(CommentDto dto);
    void updateCommentRatingById(int commentId, int rating);
}
