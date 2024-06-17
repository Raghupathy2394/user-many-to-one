package com.springcrud.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcrud.user.Dto.UserAddressDto;
import com.springcrud.user.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
//	@Query("SELECT u FROM User u WHERE   u.name = :name ")   
//	List<User> findByName(String name);

	@Query("select u from User u where u.gender= :gender")
	User findByGender(String gender);

	
//	@Query("select u from User  u where cast(u.id as string) like %:key% or u.name like %:key%"
//			+ " or u.gender like %:key% or cast(u.age as String) like %:key%")
//	

	@Query(value = "select userdb.age, userdb.gender, userdb.name, useraddress.contact, useraddress.addresstype, useraddress.city "
            + "from userdb inner join useraddress "
            + "on userdb.id = useraddress.adid "
            + "where userdb.name like %:key% or userdb.gender like %:key% or "
            + "useraddress.contact like %:key% or useraddress.addresstype like %:key% or "
            + "useraddress.city like %:key%", nativeQuery = true)
         List<Object> getByAny(Object key);


	@Query(value="select u.name as Username, u.age as Userage, u.gender as Usergender, "
			+ "a.city as city, a.contact as contact, a.addresstype as addresstype "
			+ "from userdb u inner join useraddress a on u.id=a.user_adid ",nativeQuery=true)
	List<UserAddressDto> findAlluser();

	@Query(value="select u.name as Username, u.age as Userage, u.gender as Usergender, "
			+ "a.city as city, a.contact as contact, a.addresstype as addresstype "
			+ "from userdb u inner join useraddress a on u.id=a.user_adid ",nativeQuery=true)
	List<UserAddressDto> findByName(String name); 

	
	
}
