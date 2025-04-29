package com.revisao.ecommerce.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.revisao.ecommerce.dto.CategoriaDTO;
import com.revisao.ecommerce.entities.Categoria;
import com.revisao.ecommerce.repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.dto.ProdutoDTO;
import com.revisao.ecommerce.entities.Produto;
import com.revisao.ecommerce.repositories.ProdutoRepository;


@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repo;

	@Autowired
	CategoriaRepository catRepo;

	public List<ProdutoDTO> findAll() {
		List<Produto> lista = repo.findAll();

		return lista.stream().map(x -> new ProdutoDTO(x)).toList();
	}

	public Page<ProdutoDTO> findPagina(Pageable pagina) {
		Page<Produto> busca = repo.findAll(pagina);
		return busca.map(x -> new ProdutoDTO(x));
	}

	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entity = new Produto();
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setPreco(dto.getPreco());
		entity.setImgUrl(dto.getImgUrl());

		for (CategoriaDTO cdto : dto.getCategorias()) {
			Categoria categoria = catRepo.getReferenceById(cdto.getId());
			entity.getCategorias().add(categoria);
		}
		entity = repo.save(entity);
		return new ProdutoDTO(entity);
	}

	public ProdutoDTO updateProduct(Long id, ProdutoDTO dto) {
		Produto produto = repo.findById(id).get();
		if (produto.getId() != null) {
			if (dto.getImgUrl() != null && !dto.getImgUrl().isBlank()) {
				produto.setImgUrl(dto.getImgUrl());
			}
			if (dto.getNome() != null && !dto.getNome().isBlank()) {
				produto.setNome(dto.getNome());
			}
			if (dto.getDescricao() != null && !dto.getDescricao().isBlank()) {
				produto.setDescricao(dto.getDescricao());
			}
			if (dto.getPreco() != null) {
				produto.setPreco(dto.getPreco());
			}

			produto = repo.save(produto);
			return new ProdutoDTO(produto);
		} else {
		return null;
		}
	}


	public boolean dellProduct(Long id){
		Optional<Produto> produto = repo.findById(id);
		if(produto.isPresent()){
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}






