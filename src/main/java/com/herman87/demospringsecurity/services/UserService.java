package com.herman87.demospringsecurity.services;

import com.herman87.demospringsecurity.domain.User;
import com.herman87.demospringsecurity.domain.model.UserDTO;
import com.herman87.demospringsecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public Long createUser(UserDTO userDTO) {
        return Optional.ofNullable(userDTO)
                .map(user1 -> User.builder()
                        .username(userDTO.getUsername())
                        .password(userDTO.getPassword())
                        .build())
                .map(userRepository::save)
                .map(User::getId)
                .orElseThrow();
    }

    @Transactional
    public void connect(UserDTO userDTO) {

    }

    public void activateUserById(Long id) {

    }
}
