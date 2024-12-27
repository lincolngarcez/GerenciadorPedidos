package br.com.alura.gerenciadorpedidos;

import br.com.alura.gerenciadorpedidos.main.Principal;
import br.com.alura.gerenciadorpedidos.repository.CategoriaRepository;
import br.com.alura.gerenciadorpedidos.repository.FornecedorRepository;
import br.com.alura.gerenciadorpedidos.repository.PedidoRepository;
import br.com.alura.gerenciadorpedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(categoriaRepository, produtoRepository, fornecedorRepository, pedidoRepository);
		principal.principal();
	}
}
