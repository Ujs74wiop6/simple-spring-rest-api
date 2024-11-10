package br.com.cadastroalunos.service;

import br.com.cadastroalunos.entity.Aluno;
import br.com.cadastroalunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    // Create Aluno
    public Aluno createAluno(Aluno aluno) {
        return repository.save(aluno);
    }

    // List Aluno
    public List<Aluno> getAllAluno() {
        return repository.findAll();
    }

    // List by Aluno id
    public Optional<Aluno> getAlunoById(Long matricula) {
        return repository.findById(matricula);
    }

    // Delete Aluno
    public void deleteAluno(Long matricula) {
        // Verifica se o aluno existe
        if (!repository.existsById(matricula)) {
            throw new RuntimeException("Aluno com id: " + matricula + " não encontrado");
        }
        repository.deleteById(matricula);
    }

    // Update Aluno
    public Aluno updateAluno(Long matricula, Aluno aluno) {
        Optional<Aluno> oldAluno = repository.findById(matricula);

        if (oldAluno.isPresent()) {
            Aluno newAluno = oldAluno.get();
            newAluno.setNomeAluno(aluno.getNomeAluno());
            newAluno.setCpfAluno(aluno.getCpfAluno());
            newAluno.setDataNasc(aluno.getDataNasc());
            //newAluno.setCurso(aluno.getCurso());
            newAluno.setTelefoneAluno(aluno.getTelefoneAluno());
            newAluno.setEmailAluno(aluno.getEmailAluno());
            return repository.save(newAluno);
        } else {
            throw new RuntimeException("Aluno with id: " + matricula + " not found");
        }
    }

    public boolean cpfJaCadastrado(String cpfAluno) {
        return repository
                .findByCpfAluno(cpfAluno)
                .isPresent();
    }
}