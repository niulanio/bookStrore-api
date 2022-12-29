package com.niulanio.bookstrore.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.niulanio.bookstrore.service.DBService;

@Configuration
@Profile("teste")
public class TestConfig{
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public void intanciaBaseDeDados() {
		this.dbService.instanciaBD();
	}
	
	
	/*@Bean
	public boolean instanciaBaseDados2() {
		if(strategy.equals("create")) {
			this.dbService.instanciaBD();
		}
	}*/
	
}
