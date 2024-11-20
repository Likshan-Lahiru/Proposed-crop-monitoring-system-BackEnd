package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.StaffDto;
import Final.springBoot.backend.dto.impl.UserDto;
import Final.springBoot.backend.dto.status.CropStatus;

import java.util.List;

public interface UserService {
    void saveUser(UserDto UserDto);
    List<UserDto> getUserList();
    CropStatus getUserById(String userId);
    void updateUser(String userId, UserDto userDto);
    void deleteUser(String userId);
}
