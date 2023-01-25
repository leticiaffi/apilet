package br.com.leticiaisrael.apilet.services;

import br.com.leticiaisrael.apilet.domain.User;
import br.com.leticiaisrael.apilet.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findById (Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Integer id);
}
