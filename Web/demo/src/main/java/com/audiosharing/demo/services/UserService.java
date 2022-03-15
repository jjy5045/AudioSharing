package com.audiosharing.demo.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.User;
import com.audiosharing.demo.models.values.UserValue;
import com.audiosharing.demo.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
	@Transactional
	public User save(UserValue value) {
		User user = User.builder()
				.type(value.getType())
				.email(value.getEmail())
				.birthDate(value.getBirthDate())
				.name(value.getName())
				.password(value.getPassword())
				.phoneNumber(value.getPhoneNumber())
				.sex(value.getSex()).build();

		return userRepository.save(user);
	}

	@Transactional
	public int patch(long id, UserValue value) {
		Optional<User> oUser = userRepository.findById(id);
		if(oUser.isPresent()) {
			User user = oUser.get();
			if(StringUtils.isNotBlank(value.getType()))
				user.setType(value.getType());
			if(StringUtils.isNotBlank(value.getEmail()))
				user.setEmail(value.getEmail());
			if(StringUtils.isNotBlank(value.getBirthDate()))
				user.setBirthDate(value.getBirthDate());
			if(StringUtils.isNotBlank(value.getName()))
				user.setName(value.getName());
			if(StringUtils.isNotBlank(value.getPassword()))
				user.setPassword(value.getPassword());
			if(StringUtils.isNotBlank(value.getPhoneNumber()))
				user.setPhoneNumber(value.getPhoneNumber());
			if(StringUtils.isNotBlank(value.getSex()))
				user.setSex(value.getSex());
			userRepository.save(user);
			return 1;
		}
		return 0;
	}

	@Transactional
	public int delete(long id) {
		Optional<User> oUser = userRepository.findById(id);
		if(oUser.isPresent()) {
			userRepository.delete(oUser.get());
			return 1;
		}
		return 0;
	}
}
