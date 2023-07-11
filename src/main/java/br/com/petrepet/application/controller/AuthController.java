package br.com.petrepet.application.controller;

import br.com.petrepet.application.config.security.JWTGenerator;
import br.com.petrepet.application.dto.input.LoginRequest;
import br.com.petrepet.application.dto.output.LoginResponse;
import br.com.petrepet.application.mapper.UsuarioMapper;
import br.com.petrepet.core.usuario.Usuario;
import br.com.petrepet.infrastructure.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AuthController {

    private final JWTGenerator jwtGenerator;
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public AuthController(JWTGenerator jwtGenerator, AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.jwtGenerator = jwtGenerator;
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping("/login")
    public LoginResponse token(@RequestBody LoginRequest userLogin) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getNome(), userLogin.getSenha()));
        Usuario usuario = usuarioRepository.findByNome(userLogin.getNome())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado"));
        return usuarioMapper.usuarioMapperLoginResponse(usuario,jwtGenerator.generateToken(authentication));
    }

}
