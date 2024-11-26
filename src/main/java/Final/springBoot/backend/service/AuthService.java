package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.UserDto;
import Final.springBoot.backend.secure.JWTAuthResponse;
import Final.springBoot.backend.secure.SignIn;

public interface AuthService  {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(UserDto userDTO);
    JWTAuthResponse refreshToken(String refreshToken);
}
