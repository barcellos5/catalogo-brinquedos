package br.com.uauBrinquedos.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.uauBrinquedos.model.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
	
	// pesquisa por nome
	Usuario findByNome(String nome);

	// lista de alunos pelo primeiro nome
	List<Usuario> findByNomeStartsWith(String nome);
	
	// lista de alunos pelo ultimo nome
		List<Usuario> findByNomeEndsWith(String nome);

		// lista de qualquer aluno 
		List<Usuario> findByNomeContains(String nome);	
	
}
