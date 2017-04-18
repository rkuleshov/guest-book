package com.skywind.service;

import com.skywind.dao.CommentDAO;
import com.skywind.model.Comment;
import com.skywind.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rost on 17.04.2017.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    @Transactional
    public List<Comment> getAll() {
        return commentDAO.getAll();
    }

    @Override
    @Transactional
    public List<Comment> getAll(int offset, int limit){
       return commentDAO.getAll(offset, limit);
    }

    @Override
    @Transactional
    public CommentDto save(CommentDto dto){
        Comment comment = new Comment();
        comment.setText(dto.getText());
        comment.setTitle(dto.getTitle());
        comment.setRating(dto.getRating());
        Integer savedCommentId = commentDAO.save(comment);
        dto.setId(savedCommentId);
        return dto;
    }

    @Override
    @Transactional
    public void updateCommentRatingById(int commentId, int rating){
        commentDAO.updateCommentRatingById(commentId, rating);
    }

}
