package Com.SecurityAuthontiction.Service;

import java.util.List;

import Com.SecurityAuthontiction.Payloads.UserDto;

public interface UserService {

	UserDto CreateUser(UserDto userDto);
	
	UserDto UpdateUser(UserDto userDto ,Integer userId);
	
	UserDto getByUserId(Integer userId);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Integer userId);
}
