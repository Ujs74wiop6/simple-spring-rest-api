package br.com.cadastroalunos.repository;

import br.com.cadastroalunos.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByCpfAluno(String cpfAluno);
}