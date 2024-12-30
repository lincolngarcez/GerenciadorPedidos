package br.com.alura.gerenciadorpedidos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Fornecedor() {}

    public Fornecedor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
