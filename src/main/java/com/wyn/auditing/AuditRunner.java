package com.wyn.auditing;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wyn.auditing.domain.MyEntity;
import com.wyn.auditing.repositories.MyEntityRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor

public class AuditRunner implements CommandLineRunner{

	private final MyEntityRepository entityRepository;
	
	public void run(String... args) throws Exception {
		
		MyEntity entityOne = new MyEntity();
		entityOne.setDescription("Entity1");
		entityOne.setPrice(BigDecimal.ONE);
		entityOne.setImageUrl("http://testimage");
		
		MyEntity entityTwo = new MyEntity();
		entityTwo.setDescription("Entity2");
		entityTwo.setPrice(BigDecimal.TEN);
		entityTwo.setImageUrl("http://testimage");
		
		entityRepository.save(entityOne);
		entityRepository.save(entityTwo);
	}

}
