package com.nagarro.test.backend.services;

import java.util.List;
import java.util.Set;

import com.nagarro.test.backend.model.Comment;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    
    // create comment
    public Comment createComment(Comment comment);

    // update comment
    public Comment editComment(Comment comment);

    // get all comments
    public Set<Comment> getAllComment();

    // get single comment
    public Comment getSingleComment(Long cid);

    // delete comment
    public void deleteComment(Long cid);

    // total comments
    public Long count();

    //    get all comment by product id
    public List<Comment> getAllComments(Long pid);

}
