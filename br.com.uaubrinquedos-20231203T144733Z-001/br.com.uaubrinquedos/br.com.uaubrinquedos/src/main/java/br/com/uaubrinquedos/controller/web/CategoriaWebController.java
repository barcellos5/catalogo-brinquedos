package br.com.uaubrinquedos.controller.web;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import br.com.uaubrinquedos.model.entity.Categoria;
import br.com.uaubrinquedos.model.repository.CategoriaRepository;

@Controller
@RequestMapping("/categorias")
public class CategoriaWebController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@GetMapping("/index")
	public String index(){
		return "index";
	}

	@GetMapping("/list")
	public String listAll (Model model) {
		List<Categoria> categoria = categoriaRepository.findAll();
		model.addAttribute("categoria", categoria);
		return "list";
	}
	
	@GetMapping("/{nome}")
	public String getById(Model model, @PathVariable String nome) {
		Optional<Categoria> categoria = categoriaRepository.findById(nome);
		model.addAttribute("categoria", categoria);
		return "read";
	}
	
	@GetMapping("/new")
	public String newCategoria(Model model) {
	
	model
	.addAttribute("categoria", new Categoria())
	.addAttribute("novo", true);
	return "form";
}

	@PostMapping("/save")
	public String saveCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
		return "redirect:/categoria/list";
	}
	
	@GetMapping("/{nome}/delete")
	public String deleteCategoria(@PathVariable String nome) {
		Optional<Categoria> categoriaDelete = categoriaRepository.findById(nome);
		if(categoriaDelete.isPresent())categoriaRepository.deleteById(nome);
		return"redirect:/categorias/list";
	}
	
	@GetMapping("/{nome}/edit")
	public String editCategoria(Model model, @PathVariable String nome) {
		Categoria categoria = categoriaRepository.findById(nome).get();
	
	model
	.addAttribute("categoria", categoria)
	.addAttribute("novo", false);
	
	return "form";
}
	

}
