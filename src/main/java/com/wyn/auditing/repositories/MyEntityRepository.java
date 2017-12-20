package com.wyn.auditing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wyn.auditing.domain.MyEntity;

@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, Long>{

}
