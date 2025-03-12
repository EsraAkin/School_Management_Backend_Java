package com.techproed.schoolmanagementbackendb326.service.user;

import com.techproed.schoolmanagementbackendb326.entity.concretes.user.UserRole;
import com.techproed.schoolmanagementbackendb326.entity.enums.RoleType;
import com.techproed.schoolmanagementbackendb326.exception.ResourceNotFoundException;
import com.techproed.schoolmanagementbackendb326.payload.messages.ErrorMessages;
import com.techproed.schoolmanagementbackendb326.repository.user.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;


    @PostConstruct
    public void initRoles() {
        if (userRoleRepository.count() == 0) { // Eğer roller yoksa ekle
            List<UserRole> roles = Arrays.asList(
                    new UserRole(null, RoleType.ADMIN, RoleType.ADMIN.getName()),
                    new UserRole(null, RoleType.MANAGER, RoleType.MANAGER.getName()),
                    new UserRole(null, RoleType.ASSISTANT_MANAGER, RoleType.ASSISTANT_MANAGER.getName()),
                    new UserRole(null, RoleType.STUDENT, RoleType.STUDENT.getName()),
                    new UserRole(null, RoleType.TEACHER, RoleType.TEACHER.getName())
            );
            userRoleRepository.saveAll(roles);
        }
    }



    public UserRole getUserRole(RoleType roleType){
        return userRoleRepository.findByUserRoleType(roleType)
                .orElseThrow(()->new ResourceNotFoundException(ErrorMessages.ROLE_NOT_FOUND));
    }

}
