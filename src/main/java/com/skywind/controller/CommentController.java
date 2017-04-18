package com.skywind.controller;

import com.skywind.model.Comment;
import com.skywind.dto.CommentDto;
import com.skywind.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/")
    public String getAll(Map<String, Object> map) {
        List<Comment> comments = commentService.getAll();
        map.put("comments", comments);
        return "comments";
    }

    @RequestMapping("/getByOffsetAndLimit")
    public String getByOffsetAndLimit(Map<String, Object> map,
                                      @RequestParam int offset,
                                      @RequestParam int limit) {
        List<Comment> comments = commentService.getAll(offset, limit);
        map.put("comments", comments);
        return "comments";
    }

    @RequestMapping("/addComment")
    @ResponseBody
    public CommentDto create(CommentDto dto) {
        return commentService.save(dto);
    }

    @RequestMapping("/updateRating")
    public void updateCommentRatingById(@RequestParam Integer commentId,
                                        @RequestParam Integer rating){
        commentService.updateCommentRatingById(commentId, rating);
    }
}