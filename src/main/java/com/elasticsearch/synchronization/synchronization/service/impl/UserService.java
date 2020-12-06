package com.elasticsearch.synchronization.synchronization.service.impl;

import com.elasticsearch.synchronization.synchronization.model.User;
import com.elasticsearch.synchronization.synchronization.model.dto.UserDTO;
import com.elasticsearch.synchronization.synchronization.repo.IUserDAO;
import com.elasticsearch.synchronization.synchronization.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Component
public class UserService implements IUserService {

    private final IUserDAO userDAO;
    private final UserMapper userMapper;

    public UserService(IUserDAO userDAO, UserMapper userMapper) {
        this.userDAO = userDAO;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = this.userDAO.save(this.userMapper.toUser(userDTO));
        return this.userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO findById(Long id) {
        return this.userMapper.toUserDTO(this.userDAO.findById(id).orElse(null));
    }

    @Override
    public List<UserDTO> findAll() {
        return this.userMapper.toUserDtos(this.userDAO.findAll());
    }
}
