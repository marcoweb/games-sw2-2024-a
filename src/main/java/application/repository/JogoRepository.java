package application.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    public Set<Jogo> findByTitulo(String titulo);
}
