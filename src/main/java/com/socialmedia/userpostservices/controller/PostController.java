package com.socialmedia.userpostservices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.userpostservices.model.Post;
import com.socialmedia.userpostservices.model.Reply;
import com.socialmedia.userpostservices.repository.PostRepository;

@RestController
public class PostController {

	@Autowired
	PostRepository PostRepository;

	@PostMapping(path = "post")
	public ResponseEntity<Map<String, String>> createReply(@Valid @RequestBody Post post) {

		Post _post = PostRepository.save(post);

		Map<String, String> response = new HashMap<String, String>();

		response.put("message", "Post save successfully ");
		return ResponseEntity.accepted().body(response);

	}

	@GetMapping(path = "/post")
	public List<Post> retrieveAllPost() {
		return PostRepository.findAll();
	}

	@GetMapping(path = "/post/{Id}")
	public Optional<Post> retrievePost(@PathVariable int Id) throws Exception {

		Optional<Post> post = PostRepository.findById(Id);
		if (!post.isPresent())
			throw new Exception("reply is not Exist : id -" + Id);

		return post;
	}

	@DeleteMapping(path = "/delete/post/{userId}")
	public ResponseEntity<Map<String, String>> deletePostByUserId(@PathVariable int userId) {

		PostRepository.deleteByUserId(userId);

		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "User Post Delete successfully ");
		return ResponseEntity.accepted().body(response);
	}

}
