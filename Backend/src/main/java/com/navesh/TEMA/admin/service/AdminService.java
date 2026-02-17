package com.navesh.TEMA.admin.service;

import com.navesh.TEMA.admin.dto.AddUserRequest;
import com.navesh.TEMA.admin.dto.UpdateUserRequest;
import com.navesh.TEMA.common.entity.User;
import com.navesh.TEMA.common.exception.ResourceNotFoundException;
import com.navesh.TEMA.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(AddUserRequest request) {

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        return userRepository.save(user);
    }

    public User updateUser(Long id, UpdateUserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (request.getFullName() != null)
            user.setFullName(request.getFullName());

        if (request.getEnabled() != null)
            user.setEnabled(request.getEnabled());

        return userRepository.save(user);
    }
}
