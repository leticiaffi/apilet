package br.com.leticiaisrael.apilet.config;

import br.com.leticiaisrael.apilet.domain.User;
import br.com.leticiaisrael.apilet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB(){
        User u1 = new User(null, "Leticia","leticiafisrael@gmail.com","123");
        User u2 = new User(null, "Pedro","pedropit@gmail.com","123");
        User u3 = new User(null, "Dawson","dawsonfi@gmail.com","303");

        repository.saveAll(List.of(u1,u2,u3));
    }

}
