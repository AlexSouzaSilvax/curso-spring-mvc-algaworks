package com.algaworks.cobranca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

@RestController
@RequestMapping("/api")
public class TituloJsonController {

	@Autowired
	private Titulos titulos;

	@CrossOrigin
	@RequestMapping("/todosTitulos")
	public List<Titulo> getTodosTitulos() {		
		List<Titulo> listaTitulos = titulos.findAll();		
		return listaTitulos;
	}
	
}
