package com.audiosharing.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.audiosharing.demo.models.entities.StationList;
import com.audiosharing.demo.models.entities.User;
import com.audiosharing.demo.models.values.UserValue;
import com.audiosharing.demo.services.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/login", produces = { MediaType.APPLICATION_JSON_VALUE })
@RestController
@SessionAttributes("response")
public class LoginController {

	private final UserService userService;
	
	/*
	@PostMapping("")
	public Map<String, Object> findByUserIdAndUserPassword(@RequestBody Long userID, String UserPassword) {
		Map<String, Object> response = new HashMap<>();
		
		Optional<User> oUser = userService.findByUserIdAndUserPassword(userID, UserPassword);
		
		if (oUser.isPresent()) {
			response.put("result", "SUCCESS");
			response.put("user", oUser.get());
		} else {
			response.put("result", "FAIL");
			response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
		}

		return response;
	}
	*/
	
	@PostMapping("")
	public Map<String, Object> findByUserIdAndUserPassword(@RequestBody UserValue value, HttpSession session) {
		Map<String, Object> response = new HashMap<>();
		
		Optional<User> oUser = userService.findByUserEmailAndUserPassword(value.getUserEmail(), value.getUserPassword());
		
		if (oUser.isPresent()) {
			response.put("result", "SUCCESS");
			response.put("oUser", oUser.get());
			
			// 세션에 로그인 회원 정보 보관 
			session.setAttribute("oUser", oUser);
			session.setAttribute("LOGIN_MEMBER_ID", "USER");

			
		} else {
			response.put("result", "FAIL");
			response.put("reason", "일치하는 회원 정보가 없습니다. 입력 정보를 다시 확인하세요.");
		}

		return response;
	}
	
	@GetMapping("/session")
	public Map<String, Object> get(@SessionAttribute(name = "oUser", required = false) Optional<User> oUser, HttpSession session) {
		Map<String, Object> response = new HashMap<>();
		
		if(oUser.isEmpty()) {
			response.put("일치하지 않음", "FAIL");
			return response;
		}
		
		//return oUser.get().getUserEmail();
		else {
			response.put("세션 있음", "OK");
			response.put("session.getId()", session.getId());
			response.put("oUser.get().getUserEmail()", oUser.get().getUserEmail());
			return response;
		}
	}
	
}
