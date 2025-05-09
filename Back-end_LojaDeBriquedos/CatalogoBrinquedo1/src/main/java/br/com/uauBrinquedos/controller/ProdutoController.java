package br.com.uauBrinquedos.controller;

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
import br.com.uauBrinquedos.model.entity.Produto;
import br.com.uauBrinquedos.model.repository.ProdutoRepository;

@RestController
@RequestMapping("api/mongo/produto")

public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listAll(){
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}
	
	@GetMapping("/{id}")
	public Produto getById(@PathVariable("id") Integer id ) {
		Produto produto = produtoRepository.findById(id).get();
		return produto;
	}
	
	@PostMapping
	public Produto insert(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{id}")
	public Produto update(@RequestBody Produto produto, @PathVariable Integer id){
		// obter o produto a ser atualizado
		Produto produtoUpdate = produtoRepository.findById(id).get();
		// atualizar os dados
		produtoUpdate.setCodProd(produto.getCodProd());// alterar no DB para CODPROD e de categoria para CODCAT
		produtoUpdate.setNomeProd(produto.getNomeProd());
		produtoUpdate.setPreco(produto.getPreco());
		produtoUpdate.setCategoria(produto.getCategoria());
		produtoUpdate.setNomeImagem(produto.getNomeImagem());
		produtoUpdate.setDescricao(produto.getDescricao());
		produtoRepository.save(produtoUpdate);
		
		return produtoUpdate; 
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		produtoRepository.deleteById(id);
		return "Produto Excluído com Sucesso!";
	}
	
	@GetMapping("/nome/{nome}")
	public Produto getByNome(@PathVariable String nome) {
		Produto user =produtoRepository.findByNome(nome);
		return user;
	}
	
	@GetMapping("/primeiro-nome/{nome}")
	public List<Produto> getByPrimeiroNome(@PathVariable String nome) {
		List<Produto> produtos = produtoRepository.findByNomeStartsWith(nome);
		return produtos;
	}
	
	@GetMapping("/ultimo-nome/{nome}")
	public List<Produto> getByUltimoNome(@PathVariable String nome) {
		List<Produto> produtos = produtoRepository.findByNomeEndsWith(nome);
		return produtos;
	}

	@GetMapping("/contem-nome/{nome}")
	public List<Produto> getByQualquerNome(@PathVariable String nome) {
		List<Produto> produtos = produtoRepository.findByNomeContains(nome);
		return produtos;
	}

}
