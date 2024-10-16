package com.example.fbcpost.dto;

//import jakarta.persistence.GeneratedValue;

import com.example.fbcpost.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequestDto {

	private String acceptorUserName;

}