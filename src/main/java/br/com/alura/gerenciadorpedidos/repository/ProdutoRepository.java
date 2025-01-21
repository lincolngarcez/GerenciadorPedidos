package br.com.alura.gerenciadorpedidos.repository;

import br.com.alura.gerenciadorpedidos.model.Categoria;
import br.com.alura.gerenciadorpedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeIgnoreCase(String nomeProduto);
    List<Produto> findByNomeContainingIgnoreCase(String nomeProduto);
    List<Produto> findByPrecoGreaterThanEqual(Double precoPesquisado);
    List<Produto> findByPrecoLessThanEqual(Double precoPesquisado);
    List<Produto> findByCategoriaOrderByPrecoAsc(Categoria categoria);
    List<Produto> findByCategoriaOrderByPrecoDesc(Categoria categoria);
    Long countByCategoria(Categoria categoria);
    Long countByPrecoGreaterThanEqual(Double precoPesquisado);
    List<Produto> findByPrecoLessThanOrNomeContaining(Double preco, String termo);
    List<Produto> findTop3ByPrecoDesc();
    List<Produto> findTop5ByCategoriaNomeOrderByPrecoAsc(String categoriaNome);
}
