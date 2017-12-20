package com.wyn.auditing;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wyn.auditing.domain.MyEntity;
import com.wyn.auditing.repositories.MyEntityRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MyTestController {

	private final MyEntityRepository entityRepository;

	@PostMapping(name="/myentities",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> saveEntity(MyEntity entity) {
		entityRepository.save(entity);
		return ResponseEntity.ok("Successfully Posted");
	}

	@GetMapping(name="/myentities",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<MyEntity> getEntity(Long id) {
		MyEntity entity = entityRepository.findOne(id);
		return ResponseEntity.ok(entity);
	}
}
