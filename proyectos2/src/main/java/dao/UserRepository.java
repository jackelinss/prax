package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
}