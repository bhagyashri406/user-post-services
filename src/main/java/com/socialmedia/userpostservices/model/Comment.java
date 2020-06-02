package com.socialmedia.userpostservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "comment")
@Embeddable
@Entity
public class Comment {

	@Id
	@GeneratedValue
	private int commentId;

	
	@NotNull
	@Column(name = "postId", nullable = false)
	@Range(min = 1)
	private int postId;

	
	@NotNull
	@Column(name = "userId", nullable = false)
	@Range(min = 1)
	private int userId;

	@NotEmpty
	private String commentDiscription;

	
	@DateTimeFormat
	@Column(name = "createdTime", nullable = false)
	private Date createdTime;

	
	@DateTimeFormat
	@Column(name = "updateTime", nullable = false)
	private Date updateTime;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCommentDiscription() {
		return commentDiscription;
	}

	public void setCommentDiscription(String commentDiscription) {
		this.commentDiscription = commentDiscription;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Comment() {
		super();

	}

}
