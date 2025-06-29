package br.dronav.cefet.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.dronav.cefet.model.Usuario;
import br.dronav.cefet.repository.UsuarioRepository;
import br.dronav.cefet.controller.AuthService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String senha = credentials.get("senha");

        Usuario usuarioAutenticado = usuarioRepository.findByEmail(email);

        if (usuarioAutenticado != null) {
            BCryptPasswordEncoder encriptacao = new BCryptPasswordEncoder();

            if (encriptacao.matches(senha, usuarioAutenticado.getSenha())) {
                return ResponseEntity.ok(usuarioAutenticado);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha no login");
    }


}


