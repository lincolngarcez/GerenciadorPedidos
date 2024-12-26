package br.com.alura.gerenciadorpedidos.repository;

import br.com.alura.gerenciadorpedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
