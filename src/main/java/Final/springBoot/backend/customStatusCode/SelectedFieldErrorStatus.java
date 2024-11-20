package Final.springBoot.backend.customStatusCode;

import Final.springBoot.backend.dto.status.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedFieldErrorStatus implements FieldStatus {

    private int errorCode;
    private String errorMessage;
}
