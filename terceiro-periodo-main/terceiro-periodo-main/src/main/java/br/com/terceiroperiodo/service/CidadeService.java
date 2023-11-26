package br.com.terceiroperiodo.service;

import br.com.terceiroperiodo.model.Cidade;
import br.com.terceiroperiodo.repository.CidadeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//import java.util.logging.Logger;
@Slf4j
@Service
public class CidadeService {

//    private static final Logger log = Logger.getLogger(CidadeService.class.getName());

    @Autowired
    CidadeRepository cidadeRepository;

    public Cidade salvar(Cidade cidade){
        return cidadeRepository.save(cidade);
    }

    public List<Cidade> buscarTodos(){
        return cidadeRepository.findAll();
    }

    public Optional<Cidade> buscarPorId(Long id){
        return cidadeRepository.findById(id);
    }

    public Cidade atualizar(Cidade cidade) {return cidadeRepository.save(cidade);}

    public Page<Cidade> getAllCidadesByPage(Integer page, Integer size) {
        Pageable currentPage = PageRequest.of(page, size);
        Page<Cidade> response = cidadeRepository.findAll(currentPage);
        log.info("getAllCidadesByPage() - size: <{}>, context: <{}>", response.getSize(), response.getContent());
        return response;
    }

}
