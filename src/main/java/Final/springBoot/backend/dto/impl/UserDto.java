package Final.springBoot.backend.dto.impl;

import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.entity.JobRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDto implements Status {
    private String email;
    private String password;
    private JobRole role;
}
