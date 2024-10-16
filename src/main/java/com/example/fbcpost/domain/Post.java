package com.example.fbcpost.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

	private String postId;
	private String postedBy;
	private String content;
	private String parentId;
	private String mainPostId;
	private List<String> links=new ArrayList<>();
	private List<String> replies=new ArrayList<>();
	private boolean isMain;
	private boolean isComment;
//		viewBy:[]
//		date_time,

}