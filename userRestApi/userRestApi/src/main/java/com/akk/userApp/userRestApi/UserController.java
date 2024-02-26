package com.akk.userApp.userRestApi;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	public UserService service;
	
	@PostMapping("/create")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
		return new ResponseEntity<>(service.createUser(userEntity),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Optional<UserEntity> searchById(@PathVariable Integer id){
		return service.searchById(id);
	}
	
	// get all data from uset 
	
	@GetMapping("/")
	public List<UserEntity> getAll(){
		return service.getAll();	
		
	}
	
	// update user by id 
	
	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id,@RequestBody UserEntity user){
		return new ResponseEntity<>(service.updareUser(id,user),HttpStatus.OK);
	}
	
	// delete recode by id 
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Integer id) {
		service.deleteById(id);
		return "Recode has been deleted, Id is :"+id;
	}
	
	
}

