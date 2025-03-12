package com.techproed.schoolmanagementbackendb326.payload.mappers;

import com.techproed.schoolmanagementbackendb326.entity.concretes.user.User;
import com.techproed.schoolmanagementbackendb326.entity.enums.RoleType;
import com.techproed.schoolmanagementbackendb326.exception.ResourceNotFoundException;
import com.techproed.schoolmanagementbackendb326.payload.messages.ErrorMessages;
import com.techproed.schoolmanagementbackendb326.payload.request.abstracts.BaseUserRequest;
import com.techproed.schoolmanagementbackendb326.payload.response.user.UserResponse;
import com.techproed.schoolmanagementbackendb326.service.user.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final UserRoleService userRoleService;

    public User mapUserRequestToUser(BaseUserRequest userRequest, String userRole) {
        User user=User.builder()
                .username(userRequest.getUsername())
                .name(userRequest.getName())
                .surname(userRequest.getSurname())
                .password(userRequest.getPassword())
                .ssn(userRequest.getSsn())
                .birthday(userRequest.getBirthDay())
                .birthplace(userRequest.getBirthPlace())
                .phoneNumber(userRequest.getPhoneNumber())
                .gender(userRequest.getGender())
                .email(userRequest.getEmail())
                .buildIn(userRequest.getBuildIn())
                .isAdvisor(false)
                .build();


        if(userRole.equalsIgnoreCase(RoleType.ADMIN.getName())){
            if (Objects.equals(userRequest.getName(), "Admin")){
                user.setBuildIn(true);
            }
            user.setUserRole(userRoleService.getUserRole(RoleType.ADMIN));
        } else if (userRole.equalsIgnoreCase(RoleType.MANAGER.getName())) {
            user.setUserRole(userRoleService.getUserRole(RoleType.MANAGER));
        }
        else if (userRole.equalsIgnoreCase(RoleType.ASSISTANT_MANAGER.getName())) {
            user.setUserRole(userRoleService.getUserRole(RoleType.ASSISTANT_MANAGER));
        }
        else if (userRole.equalsIgnoreCase(RoleType.STUDENT.getName())) {
            user.setUserRole(userRoleService.getUserRole(RoleType.STUDENT));
        }
        else if (userRole.equalsIgnoreCase(RoleType.TEACHER.getName())) {
            user.setUserRole(userRoleService.getUserRole(RoleType.TEACHER));
        }
        else {
            throw new ResourceNotFoundException(
                    String.format(ErrorMessages.NOT_FOUND_USER_USER_ROLE_MESSAGE, userRole));
        }
        return user;
    }




    public UserResponse mapUserToUserResponse(User user) {
    return UserResponse.builder()
            .id(user.getId())
            .username(user.getUsername())
            .name(user.getName())
            .surname(user.getSurname())
            .phoneNumber(user.getPhoneNumber())
            .gender(user.getGender())
            .birthDay(user.getBirthday())
            .birthPlace(user.getBirthplace())
            .ssn(user.getSsn())
            .email(user.getEmail())
            .userRole(user.getUserRole().getRoleType().name())
            .build();

    }


}
