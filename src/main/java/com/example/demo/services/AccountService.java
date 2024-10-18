package com.example.demo.services;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;

public interface AccountService {

	public AppUser save(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser finduserByUsrname(String username);
	 public AppUser updatePassword(Integer userId, String newPassword);
}
