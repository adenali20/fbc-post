package com.example.fbcpost.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	@MongoId
	private Integer id;
	private User user;
	private Post post;
	private String message;
}