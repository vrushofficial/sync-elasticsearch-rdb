package com.elasticsearch.synchronization.synchronization.service;


import com.elasticsearch.synchronization.synchronization.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    UserDTO save(UserDTO userDTO);
    UserDTO findById(Long id);
    List<UserDTO> findAll();
}
