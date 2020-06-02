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

@Table(name = "Comment_reply")
@Embeddable
@Entity
public class CommentReply {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@Column(name = "post_id", nullable = false)
	@Range(min = 1)
	private int postId;

	@NotNull
	@Column(name = "user", nullable = false)
	@Range(min = 1)
	private int user;

	@NotEmpty
	private String comment_discription;

	@DateTimeFormat
	@Column(name = "created_time", nullable = false)
	private Date created_time;

	@DateTimeFormat
	@Column(name = "update_time", nullable = false)
	private Date update_time;

	@NotEmpty
	@NotNull
	private String parent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getComment_discription() {
		return comment_discription;
	}

	public void setComment_discription(String comment_discription) {
		this.comment_discription = comment_discription;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public CommentReply() {
		super();

	}

}
