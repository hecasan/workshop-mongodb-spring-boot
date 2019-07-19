package br.com.hetecaetano.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hetecaetano.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		User Hete = new User("1", "Héte Caetano", "hetecaetano@gmail.com");
		User Luci = new User("2", "Luci Castro", "mlucicastro@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(Hete, Luci));
		return ResponseEntity.ok(list);
	
	}

}
