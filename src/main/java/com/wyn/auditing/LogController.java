package com.wyn.auditing;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wyn.auditing.domain.LogAuditEntry;
import com.wyn.auditing.repositories.AuditRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/logs/")
public class LogController {
	
	private final AuditRepository auditRepository;
	
	@GetMapping(name="/showAll",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<LogAuditEntry>> getMyAudits() {
		List<LogAuditEntry> auditEntries = auditRepository.findAll();
		return ResponseEntity.ok(auditEntries);
	}

}
