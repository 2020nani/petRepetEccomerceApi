package br.com.petrepet.core.usuario;

import br.com.petrepet.infrastructure.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    };
    @Override

    public String deletaUsuario(String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado id: " + id));
        usuarioRepository.delete(usuario);
        return "Usuario deletado com sucesso";
    }

    @Override
    public ResponseEntity<String> deletaUsuarioMensagem(String id) {
        return null;
    }
}
