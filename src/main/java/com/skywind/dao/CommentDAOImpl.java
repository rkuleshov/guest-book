package com.skywind.dao;

import com.skywind.model.Comment;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rost on 17.04.2017.
 */
@Repository
public class CommentDAOImpl implements CommentDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Comment> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Comment");
        List<Comment> comments = query.list();
        return comments;
    }

    @Override
    public List<Comment> getAll(int offset, int limit) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Comment");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        List<Comment> comments = query.list();
        return comments;
    }

    @Override
    public Integer save(Comment comment){
        return  (Integer)sessionFactory.getCurrentSession().save(comment);
    }

    @Override
    public Comment getById(int id){
       return (Comment)sessionFactory.getCurrentSession().get(Comment.class, id);
    }

    @Override
    public void updateCommentRatingById(int commentId, int rating) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("update Comment set rating = :rating" +
                " where id = :commentId");
        query.setParameter("commentId", commentId);
        query.setParameter("rating", rating);
        query.executeUpdate();
    }
}
