package phoebe.tck.cookingapp.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import phoebe.tck.cookingapp.dto.request.UserCreationRequest;
import phoebe.tck.cookingapp.dto.response.UserResponse;
import phoebe.tck.cookingapp.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest userCreationRequest);
    UserResponse toUserResponse(User user);
//    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
