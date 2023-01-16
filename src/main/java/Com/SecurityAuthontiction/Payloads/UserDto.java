package Com.SecurityAuthontiction.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {

	    private int userId;
	    private String email;
	    private String name;
	    private String password ;
		
	    
}
