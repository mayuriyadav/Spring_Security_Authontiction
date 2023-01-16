package Com.SecurityAuthontiction.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.SecurityAuthontiction.Entity.User;
import Com.SecurityAuthontiction.Exception.ResourceNotFoundException;
import Com.SecurityAuthontiction.Payloads.UserDto;
import Com.SecurityAuthontiction.Repo.UserRepo;
import Com.SecurityAuthontiction.Service.UserService;

@Service
public class UserServiceimpl  implements UserService{
@Autowired
	private UserRepo userRepo ;
@Autowired
    private ModelMapper modelMapper;
	@Override
	public UserDto CreateUser(UserDto userDto) {
		   User user = this.modelMapper.map(userDto, User.class);
		   User saveuser   = this.userRepo.save(user);   
		   return this.modelMapper.map(saveuser, UserDto.class);
	}

	@Override
	public UserDto UpdateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		
		user.setPassword(userDto.getPassword());
		User saveUser = this.userRepo.save(user);
		return this.modelMapper.map(saveUser, UserDto.class);
	}

	@Override
	public UserDto getByUserId(Integer userId) {
	User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
	List<User> user = this.userRepo.findAll();
	List<UserDto> saveuser = user.stream().map(u -> this.modelMapper.map(u,UserDto.class)).collect(Collectors.toList());

		return saveuser;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		this.userRepo.delete(user);
	}

}
