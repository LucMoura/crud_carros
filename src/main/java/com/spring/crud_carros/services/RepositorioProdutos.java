package com.spring.crud_carros.services;

import com.spring.crud_carros.models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProdutos extends JpaRepository <Produtos, Integer> {

}
