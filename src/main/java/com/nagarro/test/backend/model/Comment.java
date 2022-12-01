package com.nagarro.test.backend.model;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;
    private String message;
    private boolean status;

    // @ManyToOne
    // @JoinColumn(name = "pid")
    // private Product product;

    // @JoinColumn(name = "pid")
    // @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    // @JsonIgnore
    // private Product product;

    // @Column(name = "pid", insertable = false, updatable = false)
    // private Long uid;

    // @ManyToOne
    // @JoinColumn(name = "uid")
    // private User user;

    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_at;

    // @Column(name = "id", insertable = false, updatable = false)
    private Long pid;

    public Comment() {
    }

    public Comment(Long cid, String message, boolean status, User user, Date created_at, Long pid) {
        this.cid = cid;
        this.message = message;
        this.status = status;
        this.user = user;
        this.created_at = created_at;
        this.pid = pid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Comment [cid=" + cid + ", created_at=" + created_at + ", message=" + message + ", pid=" + pid
                + ", status=" + status + ", user=" + user + "]";
    }

   
}
