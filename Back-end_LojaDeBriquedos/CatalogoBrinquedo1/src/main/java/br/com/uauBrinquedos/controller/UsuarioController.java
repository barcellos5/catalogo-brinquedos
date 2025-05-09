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
import br.com.uauBrinquedos.model.entity.Usuario;
import br.com.uauBrinquedos.model.repository.UsuarioRepository;

@RestController
@RequestMapping("api/mongo/usuarios")
public class UsuarioController {	
		@Autowired
		private UsuarioRepository usuarioRepository;
		
		@GetMapping
		public List<Usuario> listAll(){
			List<Usuario> usuarios = usuarioRepository.findAll();
			return usuarios;
		}
		
		@GetMapping("/{id}")
		public Usuario getById(@PathVariable("id") Integer id ) {
			Usuario usuario = usuarioRepository.findById(id).get();
			return usuario;
		}
		
		@PostMapping
		public Usuario insert(@RequestBody Usuario usuario){
			return usuarioRepository.save(usuario);
		}
		
		@PutMapping("/{id}")
		public Usuario update(@RequestBody Usuario usuario, @PathVariable Integer id){
			// obter o usuario a ser atualizado
			Usuario usuarioUpdate = usuarioRepository.findById(id).get();
			// atualizar os dados
			usuarioUpdate.setCod(usuario.getCod());
			usuarioUpdate.setnomeUsuario(usuario.getnomeUsuario());
			usuarioUpdate.setSexo(usuario.getSexo());
			usuarioUpdate.setLogin(usuario.getLogin());
			usuarioUpdate.setSenha(usuario.getSenha());
			usuarioRepository.save(usuarioUpdate);
			
			return usuarioUpdate; 
		}

		@DeleteMapping("/{id}")
		public String delete(@PathVariable Integer id) {
			usuarioRepository.deleteById(id);
			return "Usuario Excluído com Sucesso!";
		}
		
		@GetMapping("/nome/{nome}")
		public Usuario getByNome(@PathVariable String nome) {
			Usuario user =usuarioRepository.findByNome(nome);
			return user;
		}
		
		@GetMapping("/primeiro-nome/{nome}")
		public List<Usuario> getByPrimeiroNome(@PathVariable String nome) {
			List<Usuario> usuarios = usuarioRepository.findByNomeStartsWith(nome);
			return usuarios;
		}
		
		@GetMapping("/ultimo-nome/{nome}")
		public List<Usuario> getByUltimoNome(@PathVariable String nome) {
			List<Usuario> usuarios = usuarioRepository.findByNomeEndsWith(nome);
			return usuarios;
		}

		@GetMapping("/contem-nome/{nome}")
		public List<Usuario> getByQualquerNome(@PathVariable String nome) {
			List<Usuario> usuarios = usuarioRepository.findByNomeContains(nome);
			return usuarios;
		}

		
	}

