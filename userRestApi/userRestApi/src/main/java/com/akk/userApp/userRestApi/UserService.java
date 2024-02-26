package com.akk.userApp.userRestApi;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	
	public UserEntity createUser(UserEntity userCreate) {
		
		Random random =new Random();
		//int id=random.nextInt();
		String id="USER_"+random.nextInt()+"_NO";
		userCreate.setUid(id);
		
	
		return userRepo.save(userCreate);
	}


	public Optional<UserEntity> searchById(Integer id) {
		return userRepo.findById(id);
		
	}


	public List<UserEntity> getAll() {
		
		return userRepo.findAll();
	}


	public UserEntity updareUser(Integer id,UserEntity user) {
	UserEntity searched_user=userRepo.getById(id);
	searched_user.setName(user.getName());
	searched_user.setPhone(user.getPhone());	
	return userRepo.save(searched_user);
		
	}


	public void deleteById(Integer id) {
		userRepo.deleteById(id);
		
	}
}
