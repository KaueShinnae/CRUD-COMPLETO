package com.example.crud.crud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crud.crud.Repository.OrcamentoRepository;
import com.example.crud.crud.model.Orcamento;
import java.util.Optional;
import java.util.List;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;
    //cria a instancia para o repositorio que interage diretamente com o banco de dados para que a gente
    //possa utilizar nos metodos dos serviços GET POST e ETC.


    public Orcamento insertOrcamento(Orcamento orcamento) {
        return orcamentoRepository.save(orcamento);

        //chama o metodo save do OrcamentoRepository
    }

    public List<Orcamento>  selectAllOrcamento(){
        return orcamentoRepository.findAll();
    }
    //ira retornar todos os registros da tabela orcamento, pelo metodo FindAll do repository

    public Orcamento selectOrcamentoById(int id){
        Optional<Orcamento> oc = orcamentoRepository.findById(id);
        if (oc.isPresent()) {
            return oc.get();
        } else {
            return null;
        }
        //aqui colocamos optional(condicao) para buscar o metodo findByid buscar pelo id
        //e depois fazemos a verificacao se ele esta presente (true) se nao esta = null
    }

    public Orcamento aprovarOrcamento (int id) {
        Orcamento oc = selectOrcamentoById( id );
        oc.setStatus("Aprovado");
        return orcamentoRepository.save(oc);
    }

    public void deletarOrcamento(int id) {
        orcamentoRepository.deleteById(id);

    }

}
