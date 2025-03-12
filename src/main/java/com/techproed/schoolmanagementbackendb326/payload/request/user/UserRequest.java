package com.techproed.schoolmanagementbackendb326.payload.request.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.techproed.schoolmanagementbackendb326.payload.request.abstracts.BaseUserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest extends BaseUserRequest {
}
