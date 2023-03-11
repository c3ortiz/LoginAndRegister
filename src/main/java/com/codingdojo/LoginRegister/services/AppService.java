package com.codingdojo.LoginRegister.services;

import com.codingdojo.LoginRegister.models.LoginUser;
import com.codingdojo.LoginRegister.models.User;
import com.codingdojo.LoginRegister.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class AppService {
    @Autowired
    private UserRepository repoUser;

    public User register(User nuevoUsuario, BindingResult result) {
        if(!nuevoUsuario.getPassword().equals(nuevoUsuario.getConfirmPassword()))
            result.rejectValue("password","Matches", "Las contraseñas no coinciden");

        if(repoUser.findByEmail(nuevoUsuario.getEmail()).isPresent())
            result.rejectValue("email", "Unique", "El correo eléctronico ya existe");

        if(result.hasErrors()) {
            return null;
        } else {
            String encryptedPassword = BCrypt.hashpw(nuevoUsuario.getPassword(), BCrypt.gensalt());
            nuevoUsuario.setPassword(encryptedPassword);
            return repoUser.save(nuevoUsuario);
        }
    }

    public User login(LoginUser nuevoLogin, BindingResult result) {
        Optional<User> posibleUsuario = repoUser.findByEmail(nuevoLogin.getEmail());

        if(posibleUsuario.isEmpty()) {
            result.rejectValue("email", "Unique", "Correo no registrado");
            return null;
        }

        User userLogin = posibleUsuario.get();
        if(!BCrypt.checkpw(nuevoLogin.getPassword(), userLogin.getPassword())) {
            result.rejectValue("password", "Matches", "Contraseña incorrecta");
        }

        return result.hasErrors() ? null : userLogin;
    }
}
