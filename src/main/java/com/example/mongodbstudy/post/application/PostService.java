package com.example.mongodbstudy.post.application;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mongodbstudy.post.dao.PostRepository;
import com.example.mongodbstudy.post.dto.PostDto;
import com.example.mongodbstudy.post.entity.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	@Transactional
	public Post save(PostDto postDto) {
		return postRepository.save(Post.from(postDto));
	}

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findById(String id) {
		return postRepository.findById(id).orElse(null);
	}

	@Transactional
	public void updatePost(String id, PostDto postDto) {
		Post post = postRepository.findById(id).orElse(null);

		Objects.requireNonNull(post).updatePost(postDto);
		// 변경감지 지원 x
		postRepository.save(post);
	}

	@Transactional
	public void deletePost(String id) {
		postRepository.deleteById(id);
	}


}
