package Final.springBoot.backend.customStatusCode;


import Final.springBoot.backend.dto.status.CropStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCropErrorStatus  implements CropStatus {

    private int errorCode;
    private String errorMessage;

}
