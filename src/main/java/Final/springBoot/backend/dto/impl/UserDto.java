package Final.springBoot.backend.dto.impl;

import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.entity.JobRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Status {
    private String email;
    private String password;
    private JobRole role;
}
