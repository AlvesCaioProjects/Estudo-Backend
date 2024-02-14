package com.vagabackend.estudobackend.services;

import com.vagabackend.estudobackend.domain.user.User;
import com.vagabackend.estudobackend.domain.user.UserType;
import com.vagabackend.estudobackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT)
            throw new Exception("User of the type merchant is not authorize to realize the transaction!");
        if(sender.getBalance().compareTo(amount) < 0)
            throw new Exception("Insufficient balance!");
    }

    public User findById(Long Id) throws Exception {
        return this.repository.findById(Id).orElseThrow(() -> new Exception("User not found!"));
    }

    public void saveUser(User user) {
        this.repository.save(user);
    }
}
