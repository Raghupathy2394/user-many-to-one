package com.springcrud.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springcrud.user.Dto.UserDto;
import com.springcrud.user.entity.User;
import com.springcrud.user.repository.UserRepository;
import com.springcrud.user.service.UserServiceImp;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
   UserServiceImp userservice;
	
	@GetMapping("/get/{id}")
	public UserDto get(@PathVariable int id){
	return userservice.getid(id);
	}	 
	@GetMapping("/getbygender")
	public UserDto getbygender(@RequestParam String gender) {
		return userservice.getByGender(gender);
	}
	
	@GetMapping("/getalluser")
	public List<UserDto> getalluser(@RequestParam (value="name",required=false) String name){
		return userservice.getalluser(name);
	}
	@PostMapping("/post")
	public User create(@RequestBody UserDto userdto) {
		return userservice.create(userdto);
	}
	
	@PostMapping("/postall")
	public List<User> createall(@RequestBody List<UserDto> userdto){
		return userservice.createall(userdto);
	} 
	@PutMapping("/putall")
	public List<User> updatea(@RequestBody List<UserDto> userdto){
		return userservice.updateall(userdto);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return userservice.delete(id);
	} 
	
	//////// *****get any key**********///////
	
	@GetMapping("getany/{key}")
	public List<Object> getAny(@RequestParam ("key") Object key){
		return userservice.getAny(key);
				
	}
}