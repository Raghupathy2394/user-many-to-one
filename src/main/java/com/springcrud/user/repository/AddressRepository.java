package com.springcrud.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springcrud.user.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
