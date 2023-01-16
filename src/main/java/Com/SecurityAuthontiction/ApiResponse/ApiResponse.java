package Com.SecurityAuthontiction.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApiResponse {
	private String message;
	private boolean success;
}
