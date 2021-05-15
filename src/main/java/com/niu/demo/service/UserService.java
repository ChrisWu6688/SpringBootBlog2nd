package com.niu.demo.service;

import com.niu.demo.entity.User;
import com.niu.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }



    public User add(User user) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("没有找到用户！");
        }
        return user;
    }

    public User findById(int userId) {
        return userRepository.findById(userId).get();
    }

    public User modify(int userId, String userName, String password, String name, String gender, String birthday,
                       String phone, String email, String wechat, String description) {
        User user = userRepository.findByUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setName(name);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setPhone(phone);
        user.setEmail(email);
        user.setWechat(wechat);
        user.setDescription(description);
        userRepository.save(user);
        return user;
    }
}
