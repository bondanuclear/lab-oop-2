package DTO;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class SuccessfulResponse {
    private boolean success;

    public static SuccessfulResponse success() {
        return SuccessfulResponse.builder().success(true).build();
    }
}
