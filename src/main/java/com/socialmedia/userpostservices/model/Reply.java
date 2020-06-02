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

@Table(name = "Reply")
@Embeddable
@Entity
public class Reply {

	@Id
	@GeneratedValue
	private int replyId;

	@NotNull
	@Column(name = "commentId", nullable = false)
	@Range(min = 1)
	private int commentId;

	@NotNull
	@Column(name = "userId", nullable = false)
	@Range(min = 1)
	private int userId;

	@NotEmpty
	private String replyDiscription;

	
	@DateTimeFormat
	@Column(name = "createdTime", nullable = false)
	private Date createdTime;

	
	@DateTimeFormat
	@Column(name = "updateTime", nullable = false)
	private Date updateTime;

	public int getReplyId() {
		return replyId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getReplyDiscription() {
		return replyDiscription;
	}

	public void setReplyDiscription(String replyDiscription) {
		this.replyDiscription = replyDiscription;
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

	private Reply() {
		super();

	}

}
