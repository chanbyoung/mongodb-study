package com.example.mongodbstudy.post.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.mongodbstudy.post.dto.PostAddDto;

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

	public static Post from(PostAddDto postAddDto) {
		return Post.builder()
			.title(postAddDto.title())
			.content(postAddDto.content())
			.author(postAddDto.author())
			.build();
	}
}
