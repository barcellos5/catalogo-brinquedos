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

import br.com.uauBrinquedos.model.entity.Usuario;
import br.com.uauBrinquedos.model.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioWebController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping("/index")
	public String index(Model model, @RequestParam("nomeUsuario")String nomeUsuario ){
		model.addAttribute("nomeUsuario", nomeUsuario);
		return "index";
	}

	@GetMapping("/list")
	public String listAll (Model model) {
		List<Usuario> usuario = usuarioRepository.findAll();
		model.addAttribute("usuario", usuario);
		return "list";
	}
	
	@GetMapping("/{id}")
	public String getById(Model model, @PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		model.addAttribute("usuario", usuario);
		return "read";
	}
	
	@GetMapping("/new")
	public String newUsuario(Model model) {
	
	model
	.addAttribute("usuario", new Usuario())
	.addAttribute("novo", true);
	return "form";
}

	@PostMapping("/save")
	public String saveUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/usuario/list";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteUsuario(@PathVariable Integer id) {
		Optional<Usuario> usuarioDelete = usuarioRepository.findById(id);
		if(usuarioDelete.isPresent())usuarioRepository.deleteById(id);
		return"redirect:/usuarios/list";
	}
	
	@GetMapping("/{id}/edit")
	public String editUsuario(Model model, @PathVariable Integer id) {
		Usuario usuario = usuarioRepository.findById(id).get();
	
	model
	.addAttribute("usuario", usuario)
	.addAttribute("novo", false);
	
	return "form";
}
	
}