package com.example.mongodbstudy.post.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mongodbstudy.post.dao.PostRepository;
import com.example.mongodbstudy.post.dto.PostAddDto;
import com.example.mongodbstudy.post.entity.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	public Post save(PostAddDto postAddDto) {
		return postRepository.save(Post.from(postAddDto));
	}

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findById(String id) {
		return postRepository.findById(id).orElse(null);
	}


}
