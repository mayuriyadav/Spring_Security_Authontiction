package Com.SecurityAuthontiction.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import Com.SecurityAuthontiction.ApiResponse.ApiResponse;



@RestControllerAdvice

public class GlobalException {
 @ExceptionHandler(ResourceNotFoundException.class)
 public ResponseEntity<ApiResponse>resourceNotFoundException(ResourceNotFoundException ex){
	 
	 String message = ex.getMessage();
	 return new ResponseEntity<ApiResponse>(new ApiResponse(message,false),HttpStatus.NOT_FOUND);
 }
 @ExceptionHandler(ApiException.class)
 public ResponseEntity<ApiResponse>handleApiException(ResourceNotFoundException ex){
	 
	 String message = ex.getMessage();
	 return new ResponseEntity<ApiResponse>(new ApiResponse(message,false),HttpStatus.BAD_REQUEST);
 }
}
