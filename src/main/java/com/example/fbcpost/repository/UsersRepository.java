package com.example.fbcpost.repository;

import com.example.fbcpost.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<User, String> {
//    Student findByPhone(String phone);
//    Student findByName(String name);
//    @Query("{'address.city' : ?0}")
//    List<Student>  findStudentWithCity(String city);


    Optional<User> findById(String integer);
    Optional<User> findByUserName(String userName);
}

