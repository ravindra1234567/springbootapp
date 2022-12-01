package com.nagarro.test.backend.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.nagarro.test.backend.model.Comment;
import com.nagarro.test.backend.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // add Comment
    @PostMapping("/")
    public ResponseEntity<Comment> add(@RequestBody Comment comment) {
        return ResponseEntity.ok(this.commentService.createComment(comment));
    }

    // update Comment
    @PutMapping("/")
    public ResponseEntity<Comment> update(@RequestBody Comment comment) {
        return ResponseEntity.ok(this.commentService.editComment(comment));
    }

    // get Comments
    @GetMapping("/")
    public ResponseEntity<?> Comments() {
        return ResponseEntity.ok(this.commentService.getAllComment());
    }

    // get single Comment
    @GetMapping("/{pid}")
    public Comment Comment(@PathVariable("pid") Long pid) {
        return this.commentService.getSingleComment(pid);
    }

    // delete Comment
    @DeleteMapping("/{pid}")
    public void delete(@PathVariable("pid") Long pid) {
        this.commentService.deleteComment(pid);
    }

    // get all comments by product id
    @GetMapping("/product/{pid}")
    public List<Comment> getAllProductComments(@PathVariable("pid") String pid) {
        Long ll = Long.parseLong(pid);
        System.out.println("pid  ========================================== "+ll);
        return this.commentService.getAllComments(ll);
    }
}
