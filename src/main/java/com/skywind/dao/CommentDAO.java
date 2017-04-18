package com.skywind.dao;

import com.skywind.model.Comment;

import java.util.List;

/**
 * Created by Rost on 17.04.2017.
 */
public interface CommentDAO {

    List<Comment> getAll();

    List<Comment> getAll(int offset, int limit);

    Integer save(Comment comment);

    Comment getById(int id);

    void updateCommentRatingById(int commentId, int rating);
}
