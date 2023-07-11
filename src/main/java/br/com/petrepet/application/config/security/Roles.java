package br.com.petrepet.application.config.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Roles implements GrantedAuthority {
    @Id
    private String id;

    private RoleAcess roleAcess;

    @Override
    public String getAuthority() {
        return roleAcess.toString();
    }
}
