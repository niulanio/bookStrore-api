package com.niulanio.bookstrore.dtos;

import java.io.Serializable;

import com.niulanio.bookstrore.domain.Categoria;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class CategoriaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	
	@Column(length = 50)
	@NotEmpty(message = "Campo NOME é obrigatorio")
	private String nome;


	private String descricao;
	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
