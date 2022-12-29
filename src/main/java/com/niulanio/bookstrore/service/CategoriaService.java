package com.niulanio.bookstrore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.niulanio.bookstrore.domain.Categoria;
import com.niulanio.bookstrore.dtos.CategoriaDTO;
import com.niulanio.bookstrore.exceptions.DataIntegrotyViolationException;
import com.niulanio.bookstrore.exceptions.ObjectNotFoundException;
import com.niulanio.bookstrore.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository cr;

	public Categoria findById(Long id) {
		
		Optional<Categoria> categoria = cr.findById(id); 
		
		
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"+ ", Tipo: "+ Categoria.class.getName()));
	}
	
	
	public List<Categoria> findAll(){
		return cr.findAll();
		
	}
	
	public Categoria create(Categoria categoria) {
		categoria.setId(null);
		return cr.save(categoria);
	}
	
	public Categoria update(CategoriaDTO categoriaDTO, Long id) {
		Categoria categoria = findById(id);
		categoria.setNome(categoriaDTO.getNome());
		categoria.setDescricao(categoriaDTO.getDescricao());
		
		return cr.save(categoria);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			cr.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			
			throw new com.niulanio.bookstrore.exceptions.DataIntegrotyViolationException(
					"Categoria não pode ser deletada! Possui livros associados");
			
		}
		
	}
}
