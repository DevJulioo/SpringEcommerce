package com.revisao.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revisao.ecommerce.entities.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
