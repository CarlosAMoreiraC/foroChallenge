package com.foro.foro.repository;

import com.foro.foro.domain.UsuarioData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioData, Long> {
}
