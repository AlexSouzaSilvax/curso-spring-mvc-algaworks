package com.algaworks.cobranca.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView; 
import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

@Controller
//@RequestMapping("/titulos") original
@RequestMapping("/") // alterado para mapear no / por causa do heroukuapp
public class TituloController {

	@Autowired
	private Titulos titulos;

	ModelAndView mvCadTitulo = new ModelAndView("CadastroTitulo");
	
	@RequestMapping("/novo")
	public ModelAndView novo() {		
		return mvCadTitulo;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		//System.out.println("--> " + titulo.getDescricao() + " <--");
		titulos.save(titulo);		
		mvCadTitulo.addObject("mensagem", "Título salvo com sucesso!");
		return mvCadTitulo;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
	
}

