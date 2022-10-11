package controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Persona;
import services.PersonaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")

public class PersonaController {
private PersonaService personaService;

public PersonaController(PersonaService personaService) {
	this.personaService = personaService;
	
}

public ResponseEntity<?> getAll(){
	try {
		return ResponseEntity.status(HttpStatus.OK).body(personaService.findALL());
	}catch (Exception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
	}
}

@GetMapping("/{id}")
public ResponseEntity<?> getOne(@PathVariable Long id){
	try {
		return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
	}catch (Exception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
	}
}

@PostMapping("")
public ResponseEntity<?> save(@RequestBody Persona entity){
	try {
		return ResponseEntity.status(HttpStatus.OK).body(personaService.save(entity));
	}catch (Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
	}
}
@PutMapping("/{id}")
public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Persona entity){
	try {
		return ResponseEntity.status(HttpStatus.OK).body(personaService.update(id, entity));
	}catch (Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
	}
}

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable Long id){
	try {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaService.delete(id));
	}catch (Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
	}
}
}
