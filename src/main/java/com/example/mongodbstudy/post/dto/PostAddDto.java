package com.example.mongodbstudy.post.dto;

public record PostAddDto (
	String title,
	String content,
	String author
) {
}
