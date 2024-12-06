package com.example.crud.crud.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.crud.crud.Service.OrcamentoService;
import com.example.crud.crud.model.Orcamento;



@RestController
@RequestMapping("/orcamento")

public class OrcamentoController {
    @Autowired
    private OrcamentoService orcamentoService;
    //criar instancia orcamentoService da classe OrcamentoService

    @PostMapping
    public Orcamento criarOrcamento (@RequestBody Orcamento orcamento) {
        return orcamentoService.insertOrcamento(orcamento);
    }
        //criar um objeto Orcamento definido pelo @RequestBody que converto Json recebido para um objeto
        // o insertOrcamento é um metodo que salva isso no banco (cria e salva)

    @GetMapping
    public List<Orcamento> listarOrcamento() {
        return orcamentoService.selectAllOrcamento();
    }
    //criamos uma lista de Orcamento com o atributo listarOrcamento e depois retornamos para que o orcamentoService
    // selecione todos os orcamento (selectAllOrcamento)

    @PutMapping("/{id}/aprovar")
    public Orcamento aprovarOrcamento (@PathVariable int id) {
        return orcamentoService.aprovarOrcamento(id);
    }
    //esse metodo ira editar o status do orcamento de pendente que definimos para aprovado
    //@PathVariable extrai o valor {id} da url assim podendo selecionar qual orcamento queremos

    @GetMapping ("/{id}")
    public Orcamento buscarById (@PathVariable int id) {
        return orcamentoService.selectOrcamentoById(id);
    }
    //esse metodo ira buscar no banco o orcamento selecionado pelo id
    //@PathVariable extrai o valor {id} da url assim podendo selecionar qual orcamento queremos

    @DeleteMapping ("/{id}")
    public void removerOrcamento (@PathVariable int id) {
        orcamentoService.deletarOrcamento(id);
        //esse metodo ira remover/deletar o orcamento pelo id usando o @Pathvariable
    }
}
