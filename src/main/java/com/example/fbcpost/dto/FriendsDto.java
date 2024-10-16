package com.example.fbcpost.dto;

//import jakarta.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendsDto {

	private String id;
	private String friendUserName;
	private String firstName;
	private String lastName;

	private boolean isBlocked;
	private boolean isFriend;


}