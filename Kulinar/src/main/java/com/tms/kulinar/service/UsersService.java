package com.tms.kulinar.service;

import com.tms.kulinar.domain.Users;
import com.tms.kulinar.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsersService {

    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public UsersService(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    public Users getUserById(int id){
       return userRepositoryJPA.findById(id).get();
    }

    public ArrayList<Users> getAllUsers(){
        return (ArrayList<Users>) userRepositoryJPA.findAll();
    }

    public Users createUser(Users user) {
         return userRepositoryJPA.save(user);
    }

    public Users updateUserById(Users user) {
        return userRepositoryJPA.saveAndFlush(user);
    }

    public void deleteUserById(int id) {
         userRepositoryJPA.deleteById(id);
    }

}
