package com.techproed.schoolmanagementbackendb326.service.user;

import com.techproed.schoolmanagementbackendb326.entity.concretes.user.User;
import com.techproed.schoolmanagementbackendb326.payload.mappers.UserMapper;
import com.techproed.schoolmanagementbackendb326.payload.messages.SuccessMessages;
import com.techproed.schoolmanagementbackendb326.payload.request.user.UserRequest;
import com.techproed.schoolmanagementbackendb326.payload.response.businnes.ResponseMessage;
import com.techproed.schoolmanagementbackendb326.payload.response.user.UserResponse;
import com.techproed.schoolmanagementbackendb326.repository.user.UserRepository;
import com.techproed.schoolmanagementbackendb326.service.helper.MethodHelper;
import com.techproed.schoolmanagementbackendb326.service.validator.UniquePropertyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final UniquePropertyValidator uniquePropertyValidator;
    private final MethodHelper methodHelper;


    public ResponseMessage<UserResponse> saveUser(@Valid UserRequest userRequest, String userRole) {
        //validate uniq prop.
        uniquePropertyValidator.checkDuplication(
                userRequest.getUsername(),
                userRequest.getSsn(),
                userRequest.getPhoneNumber(),
                userRequest.getEmail()
        );
        //DTO->Entity
        User userToSave = userMapper.mapUserRequestToUser(userRequest, userRole);
        //save operation
        User savedUser = userRepository.save(userToSave);
        //Entity->DTO mapping
        return ResponseMessage.<UserResponse>builder()
                .returnBody(userMapper.mapUserToUserResponse(savedUser))
                .messages(SuccessMessages.USER_CREATE)
                .httpStatus(HttpStatus.OK)
                .build();

    }

    public ResponseMessage<UserResponse> getUserById(Long userId) {
        //validate if user exist in DB
        User user=methodHelper.isUserExist(userId);
        return ResponseMessage.<UserResponse>builder()
                .messages(SuccessMessages.USER_FOUND)
                .returnBody(userMapper.mapUserToUserResponse(user))
                .httpStatus(HttpStatus.OK)
                .build();

    }
}
