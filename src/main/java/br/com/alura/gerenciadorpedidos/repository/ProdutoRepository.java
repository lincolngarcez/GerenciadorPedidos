package br.com.alura.gerenciadorpedidos.repository;

import br.com.alura.gerenciadorpedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
