package br.com.uauBrinquedos.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.uauBrinquedos.model.entity.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, Integer> {
		// pesquisa por nome
		Categoria findByNome(String nome);

		// lista de categoria pelo primeiro nome
		List<Categoria> findByNomeStartsWith(String nome);
		
		// lista de categoria pelo ultimo nome
			List<Categoria> findByNomeEndsWith(String nome);

			// lista de qualquer Categoria 
			List<Categoria> findByNomeContains(String nome);	
		
}
