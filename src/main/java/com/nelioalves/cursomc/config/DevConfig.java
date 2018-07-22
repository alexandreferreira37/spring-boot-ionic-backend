package com.nelioalves.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nelioalves.cursomc.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if (!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instantiateTestDatabase();		
		
		return true;
	}

}

/* configuração da base de dados no heroku


Host ec2-54-227-240-7.compute-1.amazonaws.com
Database deltu3saii9fim
User yjsagtfjeukxqd
Port 5432
Password 05ea76fcd8916b4da664aed9992d7a559b2ec276ebecc027ef6e81f716734ccf
URI postgres://yjsagtfjeukxqd:05ea76fcd8916b4da664aed9992d7a559b2ec276ebecc027ef6e81f716734ccf@ec2-54-227-240-7.compute-1.amazonaws.com:5432/deltu3saii9fim
Heroku CLI
heroku pg:psql postgresql-dimensional-31470 --app curso-spring-ionic11

-- configuração para base local

spring.jpa.database=POSTGRESQL
spring.datasource.platform=postgres
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:postgresql://localhost:5432/curso_spring
spring.datasource.username=postgres
spring.datasource.password=xhs123
server.port=8080


*/