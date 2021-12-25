package com.myspringboot.services;

import com.myspringboot.entity.User;
import com.myspringboot.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user =  userRepository.findUserByUsername(name);
        user.getAuthorities().size();
        return user;
    }

    public List<User> getList() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.getById(id);
    }

    public void remove(Long id) {
        userRepository.delete(getById(id));
    }
}
