package com.niulanio.bookstrore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.niulanio.bookstrore.domain.Livro;
import com.niulanio.bookstrore.exceptions.ObjectNotFoundException;
import com.niulanio.bookstrore.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository lr;

	@Autowired
	private CategoriaService cs;

	public Livro findById(Long id) {

		Optional<Livro> livro = lr.findById(id);

		return livro.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado" + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Long id_cat) {
		cs.findById(id_cat);
		return lr.findAllByCategoria(id_cat);
	}

	public Livro create(Long id_cat, Livro livro) {
		livro.setId(null);
		livro.setCategoria(cs.findById(id_cat));
		return lr.save(livro);
	}

	public Livro updtade(Long id, Livro livro) {

		Livro liv = findById(id);
		updateData(liv, livro);

		return lr.save(liv);
	}

	private void updateData(Livro liv, Livro livro) {
		liv.setTitulo(livro.getTitulo());
		liv.setNome_autor(livro.getNome_autor());
		liv.setTexto(livro.getTexto());

	}

	public void delete(Long id) {
		Livro liv = findById(id);

		lr.delete(liv);

	}

}
