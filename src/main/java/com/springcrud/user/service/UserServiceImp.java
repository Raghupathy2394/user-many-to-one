package com.springcrud.user.service;

import java.util.List;
import java.util.Optional;

import com.springcrud.user.Dto.UserDto;
import com.springcrud.user.entity.User;

public interface UserServiceImp {


	List<UserDto> getalluser(String name);

	List<User> createall(List<UserDto> userdto);

	List<User> updateall(List<UserDto> userdto);

	String delete(int id);

	UserDto getid(int id);

	

	UserDto getByGender(String gender);

	List<Object> getAny(Object key);

}
