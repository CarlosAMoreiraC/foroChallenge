package com.foro.foro.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioAuthRepository extends JpaRepository<UsuarioAuth, Long> {
    UserDetails findByName(String username);
}
