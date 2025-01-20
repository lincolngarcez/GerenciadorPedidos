package br.com.alura.gerenciadorpedidos.main;

import br.com.alura.gerenciadorpedidos.model.Categoria;
import br.com.alura.gerenciadorpedidos.model.Produto;
import br.com.alura.gerenciadorpedidos.repository.CategoriaRepository;
import br.com.alura.gerenciadorpedidos.repository.FornecedorRepository;
import br.com.alura.gerenciadorpedidos.repository.PedidoRepository;
import br.com.alura.gerenciadorpedidos.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Principal {
    Scanner leitura = new Scanner(System.in);
    private CategoriaRepository categoriaRepository;
    private ProdutoRepository produtoRepository;
    private FornecedorRepository fornecedorRepository;
    private PedidoRepository pedidoRepository;

    public Principal(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository, FornecedorRepository fornecedorRepository, PedidoRepository pedidoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.fornecedorRepository = fornecedorRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public void principal() {

//        Categoria categoriaLivros = new Categoria("Livros");
//        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));
//
//        Fornecedor fornecedorTech = new Fornecedor("Tech Supplier");
//        Fornecedor fornecedorLivros = new Fornecedor("Livraria Global");
//        fornecedorRepository.saveAll(List.of(fornecedorTech, fornecedorLivros));
//
//        Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos, fornecedorTech);
//        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos, fornecedorTech);
//        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros, fornecedorLivros);
//        Produto produto4 = new Produto("Livro de Spring Boot", 150.0, categoriaLivros, fornecedorLivros);
//
//        produtoRepository.saveAll(List.of(produto1, produto2, produto3));
//
//        Pedido pedido1 = new Pedido(1L, LocalDate.now());
//        pedido1.setProdutos(List.of(produto1, produto3));
//        Pedido pedido2 = new Pedido(2L, LocalDate.now().minusDays(1));
//        pedido2.setProdutos(List.of(produto2));
//        pedidoRepository.saveAll(List.of(pedido1, pedido2));
//
//        categoriaEletronicos.setProdutos(List.of(produto1, produto2));
//        categoriaLivros.setProdutos(List.of(produto3, produto4));

//        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));

//        listaProdutosEletronicos();
//        listaDePedidos();
//        listaDeProdutosEFornecedores();
        buscaProdutoPeloNome();

        System.out.println("Busque o produto por categoria: ");
        String categoria = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByCategoriaContainingIgnoreCase(categoria);
        produtos.forEach(p -> System.out.println(p.toString()));
    }

    private void buscaProdutoPeloNome() {
        System.out.println("Busca produto pelo nome:");
        String nomeProduto = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByNomeContainingIgnoreCase(nomeProduto);
        produtos.forEach(p -> System.out.println(p.toString()));
    }

    private void listaDeProdutosEFornecedores() {
        System.out.println("\nProdutos e seus fornecedores:");
        produtoRepository.findAll().forEach(produto ->
                System.out.println("Produto: " + produto.getNome() +
                        ", Fornecedor: " + produto.getFornecedor().getNome())
        );
    }

    private void listaDePedidos() {
        System.out.println("\nPedidos e seus produtos:");
        pedidoRepository.findAll().forEach(pedido -> {
            System.out.println("Pedido " + pedido.getId() + ":");
            pedido.getProdutos().forEach(produto ->
                    System.out.println(" - " + produto.getNome())
            );
        });
    }

    private void listaProdutosEletronicos() {
        System.out.println("Produtos na categoria Eletrônicos:");
        categoriaRepository.findById(1L).ifPresent(categoria ->
                categoria.getProdutos().forEach(produto ->
                        System.out.println(" - " + produto.getNome())
                )
        );
    }
}