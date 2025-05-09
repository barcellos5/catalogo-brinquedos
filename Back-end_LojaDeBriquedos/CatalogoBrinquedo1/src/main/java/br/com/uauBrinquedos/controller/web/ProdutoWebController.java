package br.com.uauBrinquedos.controller.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.uauBrinquedos.model.entity.Produto;
import br.com.uauBrinquedos.model.repository.ProdutoRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoWebController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping("/index")
	public String index(Model model, @RequestParam("nomeProd")String nomeProd ){
		model.addAttribute("nomeProd", nomeProd);
		return "index";
	}

	@GetMapping("/list")
	public String listAll (Model model) {
		List<Produto> produto = produtoRepository.findAll();
		model.addAttribute("produto", produto);
		return "list";
	}
	
	@GetMapping("/{id}")
	public String getById(Model model, @PathVariable Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		model.addAttribute("produto", produto);
		return "read";
	}
	
	@GetMapping("/new")
	public String newProduto(Model model) {
	
	model
	.addAttribute("produto", new Produto())
	.addAttribute("novo", true);
	return "form";
}

	@PostMapping("/save")
	public String saveProduto(Produto produto) {
		produtoRepository.save(produto);
		return "redirect:/produto/list";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteProduto(@PathVariable Integer id) {
		Optional<Produto> produtoDelete = produtoRepository.findById(id);
		if(produtoDelete.isPresent())produtoRepository.deleteById(id);
		return"redirect:/produtos/list";
	}
	
	@GetMapping("/{id}/edit")
	public String editProduto(Model model, @PathVariable Integer id) {
		Produto produto = produtoRepository.findById(id).get();
	
	model
	.addAttribute("produto", produto)
	.addAttribute("novo", false);
	
	return "form";
}
	

}
