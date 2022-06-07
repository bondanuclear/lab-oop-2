package DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnrollRequest {
    private Long courseId;
    private Long count;
}
