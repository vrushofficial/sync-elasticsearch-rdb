package com.elasticsearch.synchronization.synchronization.service.impl;


import com.elasticsearch.synchronization.synchronization.model.User;
import com.elasticsearch.synchronization.synchronization.model.UserModel;
import com.elasticsearch.synchronization.synchronization.model.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper  {

    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDtos(List<User> users);

    User toUser(UserDTO userDTO);

    List<User> toUsers(List<UserDTO> userDTOS);

    UserModel toUserModel(User user);
}
