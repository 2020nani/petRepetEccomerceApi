package br.com.petrepet.application.dto.output;

import br.com.petrepet.core.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class LoginResponse {
    private Usuario user;
    private String token;
}
