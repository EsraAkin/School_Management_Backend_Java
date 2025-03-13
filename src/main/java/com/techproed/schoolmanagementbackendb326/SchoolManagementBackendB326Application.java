package com.techproed.schoolmanagementbackendb326;

import com.techproed.schoolmanagementbackendb326.entity.concretes.user.UserRole;
import com.techproed.schoolmanagementbackendb326.entity.enums.Gender;
import com.techproed.schoolmanagementbackendb326.entity.enums.RoleType;
import com.techproed.schoolmanagementbackendb326.payload.request.user.UserRequest;
import com.techproed.schoolmanagementbackendb326.repository.user.UserRoleRepository;
import com.techproed.schoolmanagementbackendb326.service.user.UserRoleService;
import com.techproed.schoolmanagementbackendb326.service.user.UserService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolManagementBackendB326Application implements CommandLineRunner {

  private final UserRoleService userRoleService;
  private final UserRoleRepository userRoleRepository;
  private final UserService userService;

  public SchoolManagementBackendB326Application(UserRoleService userRoleService,
                                                UserRoleRepository userRoleRepository, UserService userService) {
    this.userRoleService = userRoleService;
    this.userRoleRepository = userRoleRepository;
    this.userService = userService;
  }

  public static void main(String[] args) {
    SpringApplication.run(SchoolManagementBackendB326Application.class, args);
  }


  @Override
  public void run(String... args) throws Exception {

  }

  private static UserRequest getUserRequest(){
    UserRequest userRequest = new UserRequest();
    userRequest.setUsername("admin");
    userRequest.setEmail("admin@admin.com");
    userRequest.setSsn("111-11-1111");
    userRequest.setPassword("Ankara06*");
    userRequest.setBuildIn(true);
    userRequest.setName("adminName");
    userRequest.setSurname("adminSurname");
    userRequest.setPhoneNumber("111-111-1111");
    userRequest.setGender(Gender.FEMALE);
    userRequest.setBirthDay(LocalDate.of(1980,1,1));
    userRequest.setBirthPlace("Texas");
    return userRequest;
  }




}
