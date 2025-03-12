package com.techproed.schoolmanagementbackendb326.controller.user;

import com.techproed.schoolmanagementbackendb326.payload.request.user.UserRequest;
import com.techproed.schoolmanagementbackendb326.payload.response.businnes.ResponseMessage;
import com.techproed.schoolmanagementbackendb326.payload.response.user.UserResponse;
import com.techproed.schoolmanagementbackendb326.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    //save user
    @PostMapping("/save/{userRole}")
    public ResponseEntity<ResponseMessage<UserResponse>> saveUser(@RequestBody
                                                                  @Valid UserRequest userRequest,
                                                                  @PathVariable String userRole) {
        return ResponseEntity.ok(userService.saveUser(userRequest, userRole));

    }

    //get UserById
    @GetMapping("getUserById/{userId}")
    public ResponseEntity<ResponseMessage<UserResponse>> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));

    }

    //delete UserById
    @DeleteMapping("deleteUserById/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.deleteUserById(userId));

    }




}
