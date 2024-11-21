package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.UserDto;
import Final.springBoot.backend.dto.status.Status;

import java.util.List;

public interface UserService {
    void saveUser(UserDto UserDto);
    List<UserDto> getUserList();
    Status getUserById(String userId);
    void updateUser(String userId, UserDto userDto);
    void deleteUser(String userId);
}
