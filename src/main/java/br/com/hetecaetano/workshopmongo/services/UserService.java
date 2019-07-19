package br.com.hetecaetano.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hetecaetano.workshopmongo.domain.User;
import br.com.hetecaetano.workshopmongo.repository.UserRepository;

@Service
public class UserService {
		
	@Autowired
	private UserRepository repo;
	public List<User> findAll(){
		return repo.findAll();
	}
}
