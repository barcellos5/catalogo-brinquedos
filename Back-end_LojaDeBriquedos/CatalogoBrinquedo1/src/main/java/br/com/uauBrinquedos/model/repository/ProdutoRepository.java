package br.com.uauBrinquedos.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.uauBrinquedos.model.entity.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, Integer> {
	// pesquisa por nome
	Produto findByNome(String nome);

	// lista de categoria pelo primeiro nome
	List<Produto> findByNomeStartsWith(String nome);
	
	// lista de categoria pelo ultimo nome
		List<Produto> findByNomeEndsWith(String nome);

		// lista de qualquer Produto 
		List<Produto> findByNomeContains(String nome);	
	
} 
