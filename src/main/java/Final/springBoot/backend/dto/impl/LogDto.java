package Final.springBoot.backend.dto.impl;

import Final.springBoot.backend.dto.SuperDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogDto implements SuperDto {
    private String logCode;
    private Date logdate;
    private String LogDetails;
    private Long ObservedImage;
    private List<FieldDto> fieldCode;
    private List<CropDto> cropCode;
    private List<StaffDto> staffId;
}
