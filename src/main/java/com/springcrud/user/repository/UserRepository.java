package com.springcrud.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcrud.user.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("SELECT u FROM User u WHERE   u.name = :name ")   
	List<User> findByName(String name);

	@Query("select u from User u where u.gender= :gender")
	User findByGender(String gender);
	
	
	
	@Query("select u from User  u where cast(u.id as string) like %:key% or u.name like %:key%"
			+ " or u.gender like %:key% or cast(u.age as String) like %:key%")
         List<Object> getByAny(Object key); 

}
