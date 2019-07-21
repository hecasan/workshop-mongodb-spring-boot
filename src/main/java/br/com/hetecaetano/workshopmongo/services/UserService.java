package br.com.hetecaetano.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hetecaetano.workshopmongo.domain.User;
import br.com.hetecaetano.workshopmongo.dto.UserDTO;
import br.com.hetecaetano.workshopmongo.repository.UserRepository;
import br.com.hetecaetano.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
		
	@Autowired
	private UserRepository repo;
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
	}
	
	// Inserir Usuário
	
	public User Insert(User obj) {
		return repo.insert(obj);
	}
	
	// Deletar Usuário
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	// Atualizar Usuário
	
	public User update(User obj){ // Classe User recebendo um User obj como argumento
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		
	} 
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());	
	}

	public User fromDTO(UserDTO objDto) {
		return new  User(objDto.getId(), objDto.getName(), objDto.getEmail());
		
	}
}
