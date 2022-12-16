package com.niulanio.bookstrore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niulanio.bookstrore.domain.Categoria;
import com.niulanio.bookstrore.domain.Livro;
import com.niulanio.bookstrore.repository.CategoriaRepository;
import com.niulanio.bookstrore.repository.LivroRepository;

@Service
public class DBService {
	@Autowired
	private CategoriaRepository cr;
	
	@Autowired
	private LivroRepository lr;

	
	public void instanciaBD(){
		Categoria ct = new Categoria(null,"Informática","Livros de TI");
		Livro l1 = new Livro(null,"Clean code","Robert Martin","Algo aleatorio",ct);
		
		ct.getLivros().addAll(Arrays.asList(l1));
		
		this.cr.saveAll(Arrays.asList(ct));
		this.lr.saveAll(Arrays.asList(l1));
		
	}
}
