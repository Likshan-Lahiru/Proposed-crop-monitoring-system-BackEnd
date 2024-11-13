package Final.springBoot.backend.entity.impl;

import Final.springBoot.backend.entity.JobRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "userTable")
public class userEntity {
    @Id
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private JobRole role;
}
