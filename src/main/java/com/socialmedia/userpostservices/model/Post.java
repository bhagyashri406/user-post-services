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

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "post")
@Embeddable
@Entity
public class Post {

	@Id
	@GeneratedValue
	private int postId;

	@NotNull
	@Column(name = "userId", nullable = false)
	@Range(min = 1)
	private int userId;

	@NotEmpty
	private String postDiscription;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	@Column(name = "createdTime", nullable = false)
	private Date createdTime;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	@Column(name = "updateTime", nullable = false)
	private Date updateTime;

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

	public String getPostDiscription() {
		return postDiscription;
	}

	public void setPostDiscription(String postDiscription) {
		this.postDiscription = postDiscription;
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

	public Post() {
		super();

	}

}
