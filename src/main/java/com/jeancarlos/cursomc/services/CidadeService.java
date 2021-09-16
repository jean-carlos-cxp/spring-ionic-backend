package com.jeancarlos.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeancarlos.cursomc.domain.Cidade;
import com.jeancarlos.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> findCidades(Integer estadoId) {
		return cidadeRepository.findCidades(estadoId);
	}
}
