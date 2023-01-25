package br.com.leticiaisrael.apilet.services.impl;

import br.com.leticiaisrael.apilet.domain.User;
import br.com.leticiaisrael.apilet.domain.dto.UserDTO;
import br.com.leticiaisrael.apilet.repositories.UserRepository;
import br.com.leticiaisrael.apilet.services.UserService;
import br.com.leticiaisrael.apilet.services.exceptions.DataIntegratyViolationException;
import br.com.leticiaisrael.apilet.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;

    public UserServiceImpl() {
    }

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegratyViolationException("Email já cadastrado no sistema");
        }

    }

}
