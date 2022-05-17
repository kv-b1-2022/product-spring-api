package com.ecommerceapp.medicalapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceapp.medicalapp.model.User;
import com.ecommerceapp.medicalapp.repository.UserRepository;
import com.ecommerceapp.medicalapp.validation.UserValidation;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserValidation userValidation;
	
	public void save(User users) throws Exception {
		try {
			userValidation.userValidator(users);	
		userRepository.save(users);
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Optional<User> findById(Integer id){
		return null;
	}
	
	public void deleteById(Integer id) throws Exception{
		try {
			userRepository.deleteById(id);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public List<User> findall() throws Exception{
		List<User> listuser;
		try {
			listuser=userRepository.findAll();
		}catch(Exception e) {
			throw new Exception(e. getMessage());
		}
		return listuser;
	}
	
	public String  login(User user) throws Exception {
		try {
			//userValidator.loginValidation(user);
			Optional<User> userObj = userRepository.findByEmailAndPass(user.getEmail(),user.getPass());
			System.out.println(userObj);
			if (userObj.isPresent()) {
				return "success";
			} else {
				return null;
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
 
}
