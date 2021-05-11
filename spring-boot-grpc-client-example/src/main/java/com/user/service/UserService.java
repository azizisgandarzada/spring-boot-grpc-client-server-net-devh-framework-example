package com.user.service;

import com.user.client.ProductClient;
import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.mapper.UserMapper;
import com.user.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ProductClient productClient;

    @PostConstruct
    public void createUsers() {
        userRepository.save(User.builder()
                .name("Aziz")
                .surname("Isgandarzada")
                .birthdate("1996-20-11")
                .build());
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.toDto(user, productClient.getProducts(user.getId())))
                .collect(Collectors.toList());
    }


}
