package com.algaworks.cobranca.Controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

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
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private Titulos titulos;
	
	//ModelAndView mv = new ModelAndView("CadastroTitulo");

	@RequestMapping()
	public ModelAndView lista() {
		List<Titulo> listaTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulo");
		mv.addObject("titulos", listaTitulos);
		return mv;
	}

	@RequestMapping("/novo") 
	public ModelAndView novo(Titulo titulo) {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Titulo titulo) {	
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		titulos.save(titulo);		
		mv.addObject("mensagem", "Título salvo com sucesso!");
		return mv;
	}

	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}

}