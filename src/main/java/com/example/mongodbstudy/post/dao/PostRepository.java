package com.example.mongodbstudy.post.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodbstudy.post.entity.Post;

public interface PostRepository extends MongoRepository<Post, Long> {
}
