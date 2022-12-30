package com.niulanio.bookstrore.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, unique = true)
	@NotEmpty(message = "Campo TITULO é obrigatorio")
	private String titulo;
	
	@Column(length = 50)
	@NotEmpty(message = "Campo NOME DO AUTOR é obrigatorio")
	
	private String nome_autor;
	
	@Column(length = 2000000)
	@NotEmpty(message = "Campo TEXTO é obrigatorio")
	private String texto;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@JsonIgnore
	private Categoria categoria;
}
