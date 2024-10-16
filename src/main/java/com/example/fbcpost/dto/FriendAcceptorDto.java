package com.example.fbcpost.dto;

//import jakarta.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendAcceptorDto {

	private String requestorUserName;
	private String requestorFirstName;
	private String requestorLastName;

	private String acceptorFirstName;
	private String acceptorUserName;
	private String acceptorLastName;
	private String state;//pending,accepted,ignore






	

}