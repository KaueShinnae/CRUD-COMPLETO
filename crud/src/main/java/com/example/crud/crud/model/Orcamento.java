package com.example.crud.crud.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.PathVariable;

@Entity
public class Orcamento {
        //GeneretaedValue vai definir como o valor do id sera gerado
        //GenerationTupe.AUTO esta relacionado a geracao automatica do ID
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String descricao;
        private double valor;
        private String status = "Pendente";

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
