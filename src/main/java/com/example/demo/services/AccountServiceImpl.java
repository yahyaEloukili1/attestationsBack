package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;





@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public AppUser save(AppUser user) {
		String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
	AppRole role = roleRepository.findByRoleName(roleName);
	AppUser user = userRepository.findAppUsersByUsername(username);
	user.setRole(role);;
	}

	@Override
	public AppUser finduserByUsrname(String username) {
	
		return userRepository.findAppUsersByUsername(username);
	}
	  public AppUser updatePassword(Integer userId, String newPassword) {
	        AppUser user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
	        
	        String hashPW = bCryptPasswordEncoder.encode(newPassword);
	        user.setPassword(hashPW);
	        
	        return userRepository.save(user);
	    }
}
