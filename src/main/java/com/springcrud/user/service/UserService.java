package com.springcrud.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrud.user.Dto.UserAddressDto;
import com.springcrud.user.Dto.UserDto;
import com.springcrud.user.entity.User;
import com.springcrud.user.repository.AddressRepository;
import com.springcrud.user.repository.UserRepository;

@Service
public class UserService implements UserServiceImp {

	@Autowired
	UserRepository userRepo;

	@Autowired
	AddressRepository addressRepo;
	
	@Override
	public UserDto getid(int id) {
		Optional<User> entity = userRepo.findById(id);
		User user = entity.get();
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setAge(user.getAge());
		dto.setGender(user.getGender());
		dto.setAddress(user.getAddress());
		return dto;
	}
	@Override
	public UserDto getByGender(String gender) {
	User user=userRepo.findByGender(gender);
	UserDto dto=new UserDto();
	dto.setId(user.getId());
	dto.setName(user.getName());
	dto.setAge(user.getAge());
	dto.setGender(user.getGender());
	dto.setAddress(user.getAddress());
	return dto;
	}

//	@Override
//	public List<UserDto> getalluser(String name) {
//		List<User> users;
//		if (name == null) {
//			users = userRepo.findAll();
//		} else
//			users = userRepo.findByName(name);
//		List<UserDto> userdto = new ArrayList<UserDto>();
//		for (User e : users) {
//			UserDto dto = new UserDto();
//			dto.setId(e.getId());
//			dto.setName(e.getName());
//			dto.setAge(e.getAge());
//			dto.setGender(e.getGender());
//			dto.setAddress(e.getAddress());
//			userdto.add(dto);
//		}
//		return userdto; }

	
	@Override
	public User create(UserDto userdto) {
		User entity=new User();
		entity.setId(userdto.getId());
		entity.setName(userdto.getName());
		entity.setAge(userdto.getAge());
		entity.setGender(userdto.getGender());
		entity.setAddress(userdto.getAddress());
		return userRepo.save(entity);
	}

	@Override
	public List<User> createall(List<UserDto> userdto) {
		List<User> entity = new ArrayList<User>();
		for (UserDto e : userdto) {
			User obj = new User();
			obj.setId(e.getId());
			obj.setName(e.getName());
			obj.setAge(e.getAge());
			obj.setGender(e.getGender());
			obj.setAddress(e.getAddress());
			entity.add(obj);
		}
		return userRepo.saveAll(entity);

	}

	@Override
	public List<User> updateall(List<UserDto> userdto) {
		List<User> entity = new ArrayList<User>();
		for (UserDto e : userdto) {
			User obj = new User();
			obj.setId(e.getId());
			obj.setName(e.getName());
			obj.setAge(e.getAge());
			obj.setGender(e.getGender());
			obj.setAddress(e.getAddress());
			entity.add(obj);
		}
		return userRepo.saveAll(entity);

	}

	@Override
	public String delete(int id) {
		userRepo.deleteById(id);
		return "deleted";

	}
	@Override
	public List<Object> getAny(Object key) {
		return userRepo.getByAny(key);
	}
	@Override
	public List<UserAddressDto> getByName(String name) {
		if(name==null) {
			return userRepo.findAlluser();
	}else {
		return userRepo.findByName(name);
	}

	
	}
}
