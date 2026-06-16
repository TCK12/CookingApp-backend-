package phoebe.tck.cookingapp.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoebe.tck.cookingapp.dto.request.UserCreationRequest;
import phoebe.tck.cookingapp.dto.response.UserResponse;
import phoebe.tck.cookingapp.entity.User;
import phoebe.tck.cookingapp.exception.AppException;
import phoebe.tck.cookingapp.exception.ErrorCode;
import phoebe.tck.cookingapp.mapper.UserMapper;
import phoebe.tck.cookingapp.repository.UserRepository;

import java.time.LocalDate;
import java.util.HashSet;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);

//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }
}
