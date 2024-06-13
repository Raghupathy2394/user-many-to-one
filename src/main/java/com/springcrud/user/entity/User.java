package com.springcrud.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="user")
@Data
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name="name")
private String name;
@Column(name="age")
private int age;
@Column(name="gender")
private String gender;

public User(int id, String name, int age, String gender) {
	this.id = id;
	this.name = name;
	this.age = age;
	this.gender = gender;
}

public User() {
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
}


}


