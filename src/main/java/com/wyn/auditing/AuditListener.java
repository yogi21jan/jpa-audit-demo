package com.wyn.auditing;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.wyn.auditing.config.BeanUtil;
import com.wyn.auditing.domain.LogAuditEntry;
import com.wyn.auditing.domain.MyEntity;
import com.wyn.auditing.repositories.AuditRepository;

import lombok.Data;

@Component
@Data
public class AuditListener{
	
	private AuditRepository auditRepository;
	
	@PrePersist
	public void beforSave(MyEntity myEntity) {
		LogAuditEntry logAudit = new LogAuditEntry();
		BeanUtils.copyProperties(myEntity, logAudit,"id");
		logAudit.setMethodAction("INSERT");
		auditRepository = BeanUtil.getBean(AuditRepository.class);
		auditRepository.save(logAudit);
	}
	
	@PreUpdate
	public void beforUpdate(MyEntity myEntity) {
		LogAuditEntry logAudit = new LogAuditEntry();
		BeanUtils.copyProperties(myEntity, logAudit,"id");
		logAudit.setMethodAction("UPDATE");
		auditRepository = BeanUtil.getBean(AuditRepository.class);
		auditRepository.save(logAudit);
	}
	
	@PreRemove
	public void beforRemove(MyEntity myEntity) {
		LogAuditEntry logAudit = new LogAuditEntry();
		BeanUtils.copyProperties(myEntity, logAudit,"id");
		logAudit.setMethodAction("REMOVE");
		auditRepository = BeanUtil.getBean(AuditRepository.class);
		auditRepository.save(logAudit);
	}
}
