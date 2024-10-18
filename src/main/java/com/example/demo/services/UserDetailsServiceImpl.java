package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;







@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = accountService.finduserByUsrname(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		AppRole r = user.getRole();
		authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
	
		return new User(user.getUsername(),user.getPassword(),authorities);
		
			
	}

}
