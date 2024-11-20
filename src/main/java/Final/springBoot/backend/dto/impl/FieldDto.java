package Final.springBoot.backend.dto.impl;

import Final.springBoot.backend.dto.SuperDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.awt.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDto implements SuperDto {
    private String fieldCode;
    private String fieldName;
    private int fieldLocation;
    private Double fieldSize;
    private List<CropDto> crops;
    private List<StaffDto> staffField;
    private String image1;
    private String image2;
    private String logCode;
}
