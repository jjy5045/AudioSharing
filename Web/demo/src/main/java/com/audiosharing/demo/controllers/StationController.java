package com.audiosharing.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audiosharing.demo.models.entities.StationList;
import com.audiosharing.demo.models.values.StationListValue;
import com.audiosharing.demo.services.StationListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/station", produces = { MediaType.APPLICATION_JSON_VALUE })
@RestController
public class StationController {
	
	private final StationListService stationListSerivce;
	
	@GetMapping("/{id}")
	public Map<String, Object> findByStnId(@PathVariable("id") long id) {
		Map<String, Object> response = new HashMap<>();
		
		Optional<StationList> oStationList = stationListSerivce.findByStnId(id);
		if (oStationList.isPresent()) {
			response.put("result", "SUCCESS");
			response.put("user", oStationList.get());
		} else {
			response.put("result", "FAIL");
			response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
		}
		
		return response;
	}
	
	@GetMapping("/all")
	public Map<String, Object> findAll() {
		Map<String, Object> response = new HashMap<>();
		
		List<StationList> LStationList = stationListSerivce.findAll();
		if (!LStationList.isEmpty()) {
			response.put("result", "SUCCESS");
			response.put("user", LStationList);
		} else {
			response.put("result", "FAIL");
			response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
		}
		
		return response;
	}
	
	@PostMapping("")
	public Map<String, Object> save(@RequestBody StationListValue value) {
		Map<String, Object> response = new HashMap<>();

		StationList station = stationListSerivce.save(value);
		if (station != null) {
			response.put("result", "SUCCESS");
			response.put("user", station);
		} else {
			response.put("result", "FAIL");
			response.put("reason", "스테이션 추가 성공");
		}

		return response;
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Object> delete(@PathVariable("id") long id) {
		Map<String, Object> response = new HashMap<>();

		if(stationListSerivce.delete(id) > 0) {
			response.put("result", "SUCCESS");
		} else {
			response.put("result", "FAIL");
			response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
		}

		return response;
	}
}
