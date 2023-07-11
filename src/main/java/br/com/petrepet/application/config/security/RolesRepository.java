package br.com.petrepet.application.config.security;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends MongoRepository<Roles, Long> {
}
