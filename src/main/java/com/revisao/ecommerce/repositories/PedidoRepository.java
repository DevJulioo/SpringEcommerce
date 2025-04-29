package com.revisao.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revisao.ecommerce.entities.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
