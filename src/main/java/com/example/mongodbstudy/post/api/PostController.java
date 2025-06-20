package com.example.mongodbstudy.post.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodbstudy.post.application.PostService;
import com.example.mongodbstudy.post.dto.PostAddDto;
import com.example.mongodbstudy.post.entity.Post;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

	private final PostService postService;

	@PostMapping
	public ResponseEntity<Post> addPost(@RequestBody PostAddDto post) {
		Post save = postService.save(post);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts() {
		List<Post> posts = postService.findAll();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Post> getPostById(@PathVariable String id) {
		Post post = postService.findById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
}
