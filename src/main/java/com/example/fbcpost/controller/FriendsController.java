package com.example.fbcpost.controller;

import com.example.fbcpost.dto.StdUserDto;
import com.example.fbcpost.model.FriendRequest;
import com.example.fbcpost.domain.FriendsRequestNotifications;
import com.example.fbcpost.domain.User;
import com.example.fbcpost.dto.FriendRequestDto;
import com.example.fbcpost.dto.FriendsDto;
import com.example.fbcpost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fbcpost")
@CrossOrigin({"*"})
public class FriendsController {

    List<String> users=new ArrayList<>(
            Arrays.asList("aden mohamed ali","maryan mohamed ali","abdullahi mohamed","salah farah","farah ali"));

    @Autowired
    UserService userService;


    @PostMapping("/sendFriendRequest")
    public User saveUser(@RequestBody FriendRequestDto friendRequestDto,Authentication authentication) {
        User acceptor=userService.findUserByUserName(friendRequestDto.getAcceptorUserName());
        User requestor =userService.findUserByUserName(authentication.getName());

        StdUserDto stdUserAcceptor=new StdUserDto();
        stdUserAcceptor.setUserName(acceptor.getUserName());
        stdUserAcceptor.setFirstName(acceptor.getFirstName());
        stdUserAcceptor.setLastName(acceptor.getLastName());

        StdUserDto stdUserRequestor=new StdUserDto();
        stdUserRequestor.setUserName(requestor.getUserName());
        stdUserRequestor.setFirstName(requestor.getFirstName());
        stdUserRequestor.setLastName(requestor.getLastName());

        FriendsRequestNotifications notification=new FriendsRequestNotifications();
        notification.setId(UUID.randomUUID().toString());
        notification.setState("pending");
        notification.setAccepter(stdUserAcceptor);
        notification.setRequestor(stdUserRequestor);


        acceptor.getFriendRequestNotifications().add(notification);
        requestor.getFriendRequestNotifications().add(notification);

        userService.saveUser(acceptor);
//        userService.saveUser(requestor);
//
//        // get request nod and add friend
//        FriendsDto friendsDto=new FriendsDto();
//        friendsDto.setId(UUID.randomUUID().toString());
//        friendsDto.setFirstName(acceptor.getFirstName());
//        friendsDto.setLastName(acceptor.getLastName());
//        friendsDto.setFriendUserName(acceptor.getUserName());
//        requestor.getFriends().add(friendsDto);
        userService.saveUser(requestor);


        return acceptor;
    }

    private void handShake(User user1, User user2) {

        FriendsDto friendsDto1=new FriendsDto();
        friendsDto1.setFirstName(user1.getFirstName());
        friendsDto1.setLastName(user1.getLastName());
        friendsDto1.setFriendUserName(user1.getUserName());
        friendsDto1.setFriend(true);


        FriendsDto friendsDto2=new FriendsDto();
        friendsDto2.setFirstName(user2.getFirstName());
        friendsDto2.setLastName(user2.getLastName());
        friendsDto2.setFriendUserName(user2.getUserName());
        friendsDto2.setFriend(true);

        user1.getFriends().add(friendsDto2);
        user2.getFriends().add(friendsDto1);
        userService.saveUser(user1);
        userService.saveUser(user2);
    }

    @GetMapping("/acceptFriendRequest/{nid}/{status}")
    public User acceptFriendRequest(@PathVariable String nid,@PathVariable String status, Authentication authentication) {

        User loggedInUser=userService.findUserByUserName(authentication.getName());
        loggedInUser.getFriendRequestNotifications().stream().filter(e->e.getId().equals(nid)).findFirst().ifPresent(n1->{
            n1.setState("accepted");
            User friend=userService.findUserByUserName(n1.getRequestor().getUserName());
            friend.getFriendRequestNotifications().stream().filter(e->e.getId().equalsIgnoreCase(nid)).findFirst().ifPresent(n2->{
                n2.setState("accepted");
                handShake(loggedInUser,friend);
            });
        });
        return loggedInUser;
    }

    @GetMapping("/getFriendRequest")
    public List<FriendsRequestNotifications> getUser(Authentication authentication) {

        return  userService.findUserByUserName(authentication.getName()).
                getFriendRequestNotifications().stream().filter(e->e.getState().equalsIgnoreCase("pending")).
                collect(Collectors.toUnmodifiableList());

    }
    @GetMapping("/getFriends")
    public List<FriendsDto> getFriends(Authentication authentication) {

        return  userService.findUserByUserName(authentication.getName()).getFriends();

    }
}
