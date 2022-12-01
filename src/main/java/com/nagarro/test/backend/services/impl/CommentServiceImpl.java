package com.nagarro.test.backend.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nagarro.test.backend.model.Comment;
import com.nagarro.test.backend.repo.CommentRepository;
import com.nagarro.test.backend.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        // TODO Auto-generated method stub
        System.out.println(comment);

        return this.commentRepository.save(comment);
    }

    @Override
    public Comment editComment(Comment comment) {
        // TODO Auto-generated method stub
        System.out.println("comment  == " + comment);
        return this.commentRepository.save(comment);
    }

    @Override
    public Set<Comment> getAllComment() {
        // TODO Auto-generated method stub
        return new HashSet<>(this.commentRepository.findAll());
    }

    @Override
    public Comment getSingleComment(Long cid) {
        // TODO Auto-generated method stub
        return this.commentRepository.findById(cid).get();
    }

    @Override
    public void deleteComment(Long cid) {
        // TODO Auto-generated method stub
        this.commentRepository.deleteById(cid);
        ;
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return this.commentRepository.count();
    }

    @Override
    public List<Comment> getAllComments(Long pid) {
        // TODO Auto-generated method stub
        return this.commentRepository.findByPid(pid);
    }

    

  

}
