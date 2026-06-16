package phoebe.tck.cookingapp.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phoebe.tck.cookingapp.dto.request.UserCreationRequest;
import phoebe.tck.cookingapp.dto.response.ApiResponse;
import phoebe.tck.cookingapp.dto.response.UserResponse;
import phoebe.tck.cookingapp.entity.User;
import phoebe.tck.cookingapp.service.UserService;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@Builder
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder().result(userService.createUser(request)).build();
    }
}
