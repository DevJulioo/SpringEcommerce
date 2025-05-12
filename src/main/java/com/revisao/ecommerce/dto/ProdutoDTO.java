package com.revisao.ecommerce.dto;

import com.revisao.ecommerce.entities.Categoria;
import com.revisao.ecommerce.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;
	
	private List<CategoriaDTO> categorias = new ArrayList<>();


	public ProdutoDTO() {
		super();
	}





	public ProdutoDTO(String nome, String descricao, Double preco, String imgUrl) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
	}

	public ProdutoDTO(Produto p) {
		id = p.getId();
		nome = p.getNome();
		descricao = p.getDescricao();
		preco = p.getPreco();
		imgUrl = p.getImgUrl();
		for (Categoria categoria : p.getCategorias()){
			categorias.add(new CategoriaDTO(categoria));
		}
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





	public Double getPreco() {
		return preco;
	}





	public void setPreco(Double preco) {
		this.preco = preco;
	}





	public String getImgUrl() {
		return imgUrl;
	}





	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<CategoriaDTO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaDTO> categorias) {
		this.categorias = categorias;
	}



}
