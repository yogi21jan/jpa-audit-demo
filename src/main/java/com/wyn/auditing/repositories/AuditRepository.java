package com.wyn.auditing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wyn.auditing.domain.LogAuditEntry;

@Repository
public interface AuditRepository extends JpaRepository<LogAuditEntry, Long>{

}
