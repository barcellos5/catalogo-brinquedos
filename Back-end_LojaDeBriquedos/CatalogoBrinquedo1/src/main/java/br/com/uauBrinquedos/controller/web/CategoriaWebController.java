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

import br.com.uauBrinquedos.model.entity.Categoria;
import br.com.uauBrinquedos.model.repository.CategoriaRepository;

@Controller
@RequestMapping("/categorias")
public class CategoriaWebController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@GetMapping("/index")
	public String index(Model model, @RequestParam("nome")String nome ){
		model.addAttribute("nome", nome);
		return "index";
	}

	@GetMapping("/list")
	public String listAll (Model model) {
		List<Categoria> categoria = categoriaRepository.findAll();
		model.addAttribute("categoria", categoria);
		return "list";
	}
	
	@GetMapping("/{id}")
	public String getById(Model model, @PathVariable Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
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
	
	@GetMapping("/{id}/delete")
	public String deleteCategoria(@PathVariable Integer id) {
		Optional<Categoria> categoriaDelete = categoriaRepository.findById(id);
		if(categoriaDelete.isPresent())categoriaRepository.deleteById(id);
		return"redirect:/categorias/list";
	}
	
	@GetMapping("/{id}/edit")
	public String editCategoria(Model model, @PathVariable Integer id) {
		Categoria categoria = categoriaRepository.findById(id).get();
	
	model
	.addAttribute("categoria", categoria)
	.addAttribute("novo", false);
	
	return "form";
}
	

}
