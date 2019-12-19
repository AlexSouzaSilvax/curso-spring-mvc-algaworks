package com.algaworks.cobranca.Controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private Titulos titulos;

	ModelAndView mvCadTitulo = new ModelAndView("CadastroTitulo");
	
	@RequestMapping("/lista")
	public ModelAndView lista(Titulo titulo) {
		mvCadTitulo = new ModelAndView("PesquisaTitulo");
		return mvCadTitulo;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(Titulo titulo) {
		return mvCadTitulo;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Titulo titulo) {			
		
		titulos.save(titulo);		
		mvCadTitulo.addObject("mensagem", "Título salvo com sucesso!");
		
		return mvCadTitulo;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
	
}

