package com.nagarro.test.backend.repo;

import java.util.List;
import java.util.Set;

import com.nagarro.test.backend.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPid(Long pid);
}
