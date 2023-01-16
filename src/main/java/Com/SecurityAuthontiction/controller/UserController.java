package Com.SecurityAuthontiction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Com.SecurityAuthontiction.ApiResponse.ApiResponse;
import Com.SecurityAuthontiction.Payloads.UserDto;
import Com.SecurityAuthontiction.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<UserDto>CreateUser(@RequestBody UserDto userDto)
	{
		UserDto user = this.userService.CreateUser(userDto);
		return new ResponseEntity<UserDto>(user,HttpStatus.CREATED);
	}
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<UserDto>UpdateUser(@RequestBody UserDto userDto ,@PathVariable Integer userId){
		UserDto user = this.userService.UpdateUser(userDto, userId);
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	
	public ResponseEntity<UserDto> getByUserId(@PathVariable Integer userId){
		 UserDto user = this.userService.getByUserId(userId);
		 return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	@GetMapping("/user")
	public ResponseEntity<List<UserDto>>getAllUser(){
		
		List<UserDto> allusers = this.userService.getAllUser();
		return new ResponseEntity<List<UserDto>>(allusers,HttpStatus.OK);
	}
	//ADMIN 
	// DELETE - delete user 
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<ApiResponse>deleteUser(@PathVariable Integer userId){
		
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully", true),HttpStatus.OK);
	}
}
