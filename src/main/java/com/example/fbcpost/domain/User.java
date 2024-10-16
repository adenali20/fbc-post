package com.example.fbcpost.domain;

//import jakarta.persistence.GeneratedValue;
import com.example.fbcpost.dto.FriendsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {




	@MongoId()
	private String id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	List<FriendsDto> friends = new ArrayList<>();
	List<FriendsRequestNotifications> friendRequestNotifications = new ArrayList<>();
	List<Post> posts = new ArrayList<>();

}