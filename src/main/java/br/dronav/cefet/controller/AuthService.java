package br.dronav.cefet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dronav.cefet.model.Usuario;
import br.dronav.cefet.repository.UsuarioRepository;

@Service
public class AuthService {
	
    @Autowired
    private UsuarioRepository usuarioRepository;
}
