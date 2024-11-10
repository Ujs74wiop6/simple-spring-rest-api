package br.com.cadastroalunos.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import org.springframework.aot.generate.Generated;
import org.springframework.context.annotation.Primary;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long matricula;

    @Column(unique = true, nullable = false)
    String cpfAluno;

    String nomeAluno, telefoneAluno, emailAluno, dataNasc;

}