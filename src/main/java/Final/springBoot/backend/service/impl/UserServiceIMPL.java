package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.dto.impl.UserDto;
import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.service.UserService;

import java.util.List;

public class UserServiceIMPL implements UserService {
    @Override
    public void saveUser(UserDto UserDto) {


    }

    @Override
    public List<UserDto> getUserList() {
        return List.of();
    }

    @Override
    public Status getUserById(String userId) {
        return null;
    }

    @Override
    public void updateUser(String userId, UserDto userDto) {

    }

    @Override
    public void deleteUser(String userId) {

    }
}
