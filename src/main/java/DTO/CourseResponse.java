package DTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseResponse {
    private Long id;
    private String name;
    private Long price;
    private Long count;
}
