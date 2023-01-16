package Com.SecurityAuthontiction.Entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Table(name="user")
@Entity
public class User implements UserDetails {
    
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	  private int userId;
	 @Column(name =  "user_name",nullable = false,length = 100)
	 private String name;
	  private String email ;
	  private String password;
	  
	  @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	  @JoinTable(name="user_role",joinColumns = @JoinColumn(name = "user",referencedColumnName="userId"),
			  inverseJoinColumns = @JoinColumn(name="role",referencedColumnName = "id"))
	  private Set<Role> role = new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<SimpleGrantedAuthority> authories=this.role.stream().map((roles)-> new SimpleGrantedAuthority(roles.getName())).collect(Collectors.toList());

	        return authories;
	}

	@Override
	public String getUsername() {
		
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		 return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		 return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		 return true;
	}

	@Override
	public boolean isEnabled() {
		
		 return true;
	}

	
}
