package com.nelioalves.cursomc.resources;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.services.DBService;

@RestController
@RequestMapping(value="/dbinicializa")
public class DBResource {
	
	@Autowired
	private DBService service;

	@RequestMapping (method=RequestMethod.GET )	
	public ResponseEntity<ResponseEntity<Void>> dbStart() throws ParseException{
		
		service.instantiateTestDatabase();
		return ResponseEntity.noContent().build();
	}
}
