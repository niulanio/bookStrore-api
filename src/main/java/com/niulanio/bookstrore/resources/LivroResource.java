package com.niulanio.bookstrore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.niulanio.bookstrore.domain.Livro;
import com.niulanio.bookstrore.dtos.LivroDTO;
import com.niulanio.bookstrore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService ls;

	@GetMapping(value = "/{id}")
	private ResponseEntity<Livro> findById(@PathVariable Long id) {
		Livro liv = ls.findById(id);

		return ResponseEntity.ok().body(liv);
	}

	@GetMapping
	private ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat) {
		List<Livro> listLivro = ls.findAll(id_cat);
		List<LivroDTO> listDTO = listLivro.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value="categoria",defaultValue="0")Long id_cat, @RequestBody Livro livro ){
		livro = ls.create(id_cat,livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro){
		
		Livro livroUpdated = ls.updtade(id,livro);
		
		return ResponseEntity.ok().body(livroUpdated);
		
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Long id, @RequestBody Livro livro){
		
		Livro livroUpdated = ls.updtade(id,livro);
		
		return ResponseEntity.ok().body(livroUpdated);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		ls.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	

}
