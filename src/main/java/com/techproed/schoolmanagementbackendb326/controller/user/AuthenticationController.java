package com.techproed.schoolmanagementbackendb326.controller.user;

import com.techproed.schoolmanagementbackendb326.payload.messages.SuccessMessages;
import com.techproed.schoolmanagementbackendb326.payload.request.authentication.LoginRequest;
import com.techproed.schoolmanagementbackendb326.payload.request.authentication.UpdatePasswordRequest;
import com.techproed.schoolmanagementbackendb326.payload.response.authentication.AuthenticationResponse;
import com.techproed.schoolmanagementbackendb326.service.user.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;


  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse>authenticate(
      @RequestBody @Valid LoginRequest loginRequest){
    return ResponseEntity.ok(authenticationService.authenticate(loginRequest));
  }

}
