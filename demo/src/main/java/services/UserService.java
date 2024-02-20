package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.User;
import repositories.UserRepository;
import service.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) throws AttributeNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new AttributeNotFoundException("Usuário não encontrado com o id fornecido: " + id);
        }
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) throws AttributeNotFoundException {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new AttributeNotFoundException("Usuário não encontrado com o id fornecido: " + id);
        }
    }

    public User update(Long id, User newUser) throws Exception {
        try {
            User existingUser = findById(id);
            existingUser.setNome(newUser.getNome());
            existingUser.setEmail(newUser.getEmail());
            return userRepository.save(existingUser);
        } catch (AttributeNotFoundException e) {
            throw new Exception("Usuário não encontrado com o id fornecido: " + id);
        }
    }
}
