package com.example.fbcpost.domain;

//import jakarta.persistence.GeneratedValue;

import com.example.fbcpost.dto.StdUserDto;
import com.example.fbcpost.model.FriendRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//@Document("friendsRequestNotifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendsRequestNotifications {

	private String id;
	private String state;
	private boolean isRemoved;
	private boolean isSeen;
	private StdUserDto requestor;
	private StdUserDto accepter;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FriendsRequestNotifications that = (FriendsRequestNotifications) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}