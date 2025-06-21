package com.example.mongodbstudy.post.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.mongodbstudy.post.dto.PostDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document
@Getter
@NoArgsConstructor
public class Post {

	@Id
	private String id;
	private String title;
	private String content;
	private String author;

	@Builder
	public Post(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public static Post from(PostDto postDto) {
		return Post.builder()
			.title(postDto.title())
			.content(postDto.content())
			.author(postDto.author())
			.build();
	}

	public void updatePost(PostDto postDto) {
		this.title = postDto.title();
		this.content = postDto.content();
		this.author = postDto.author();
	}
}
