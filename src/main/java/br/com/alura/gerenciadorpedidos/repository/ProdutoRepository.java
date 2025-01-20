package br.com.alura.gerenciadorpedidos.repository;

import br.com.alura.gerenciadorpedidos.model.Categoria;
import br.com.alura.gerenciadorpedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContainingIgnoreCase(String nomeProduto);
    List<Produto> findByCategoriaContainingIgnoreCase(Categoria categoria);

}
