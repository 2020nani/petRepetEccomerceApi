package br.com.petrepet.core.usuario;


import org.springframework.http.ResponseEntity;

public interface UsuarioService {

    public Usuario salvarUsuario(Usuario usuario);

    String deletaUsuario(String id);

    ResponseEntity<String> deletaUsuarioMensagem(String id);
}
