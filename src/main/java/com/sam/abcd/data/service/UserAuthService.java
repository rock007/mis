package com.sam.abcd.data.service;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sam.abcd.data.entity.User;
import com.sam.abcd.data.repository.UserRepository;

@Component("userAuthService")
public class UserAuthService implements UserDetailsService{

    private static final Logger loggger = LoggerFactory.getLogger(UserAuthService.class);
    
    @Autowired
    private  UserRepository userRepository;
    
	@Override
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
		
		User oneUser= userRepository.findOne(name);

		if(oneUser==null){
			
			loggger.warn("用户不存在！");
			return null;
		}
		
	    return new UserDetails() {
	      
	      private static final long serialVersionUID = 2059202961588104658L;

	      @Override
	      public boolean isEnabled() {
	        return true;
	      }
	      
	      @Override
	      public boolean isCredentialsNonExpired() {
	        return true;
	      }
	      
	      @Override
	      public boolean isAccountNonLocked() {
	        return true;
	      }
	      
	      @Override
	      public boolean isAccountNonExpired() {
	        return true;
	      }
	      
	      @Override
	      public String getUsername() {
	        return oneUser.getUserName();
	      }
	      
	      @Override
	      public String getPassword() {
	        return oneUser.getPassword();
	      }
	      
	      @Override
	      public Collection<? extends GrantedAuthority> getAuthorities() {
	        List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
	        auths.add(new SimpleGrantedAuthority("admin"));
	        return auths;
	      }
	    };
	}
	
}
