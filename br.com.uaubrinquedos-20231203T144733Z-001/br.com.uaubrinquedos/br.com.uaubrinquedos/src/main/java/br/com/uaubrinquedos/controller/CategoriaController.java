package br.com.uaubrinquedos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import br.com.uauBrinquedos.controller.Integer;
//import br.com.uauBrinquedos.controller.String;
import br.com.uaubrinquedos.model.entity.Categoria;
import br.com.uaubrinquedos.model.repository.CategoriaRepository;

@RestController
@RequestMapping("api/mongo/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> listAll(){
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias;
	}
	
	@GetMapping("/{id}")
	public Categoria getById(@PathVariable("id") String id ) {
		Categoria categoria = categoriaRepository.findById(id).get();
		return categoria;
	}
	
	@PostMapping
	public Categoria insert(@RequestBody Categoria categoria){
		return categoriaRepository.save(categoria);
	}
	
	@PutMapping("/{id}")
	public Categoria update(@RequestBody Categoria categoria, @PathVariable String id){
		// obter o categoria a ser atualizado
		Categoria categoriaUpdate = categoriaRepository.findById(id).get();
		// atualizar os dados
		categoriaUpdate.setCodCat(categoria.getCodCat());
		categoriaUpdate.setNome(categoria.getNome());
		categoriaUpdate.setLinha(categoria.getLinha());
		categoriaUpdate.setIdade(categoria.getIdade());
		categoriaUpdate.setNomeImagem(categoria.getNomeImagem());
		categoriaRepository.save(categoriaUpdate);
		
		return categoriaUpdate; 
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		categoriaRepository.deleteById(id);
		return "Categoria Excluído com Sucesso!";
	}
	
	@GetMapping("/nome/{nome}")
	public Categoria getByNome(@PathVariable String nome) {
		Categoria user =categoriaRepository.findByNome(nome);
		return user;
	}
	
	@GetMapping("/primeiro-nome/{nome}")
	public List<Categoria> getByPrimeiroNome(@PathVariable String nome) {
		List<Categoria> categorias = categoriaRepository.findByNomeStartsWith(nome);
		return categorias;
	}
	
	@GetMapping("/ultimo-nome/{nome}")
	public List<Categoria> getByUltimoNome(@PathVariable String nome) {
		List<Categoria> categorias = categoriaRepository.findByNomeEndsWith(nome);
		return categorias;
	}

	@GetMapping("/contem-nome/{nome}")
	public List<Categoria> getByQualquerNome(@PathVariable String nome) {
		List<Categoria> categorias = categoriaRepository.findByNomeContains(nome);
		return categorias;
	}
	
}