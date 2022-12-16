package com.niulanio.bookstrore.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.niulanio.bookstrore.service.DBService;

@Configuration
@Profile("teste")
public class IntanciaBD{
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public void intanciaBaseDeDados() {
		this.dbService.instanciaBD();
	}
	
	
}
