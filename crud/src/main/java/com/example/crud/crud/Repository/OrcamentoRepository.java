package com.example.crud.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.crud.crud.model.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {
}