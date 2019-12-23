package com.algaworks.cobranca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

@RestController
@RequestMapping("/titulos/api")
public class TituloJsonController {

	@Autowired
	private Titulos titulos;

	@CrossOrigin
	@RequestMapping("/todosTitulos")
	public List<Titulo> getTodosTitulos() {		

		List<Titulo> listaTitulos;
		
		try {
			listaTitulos = titulos.findAll();			
		} catch(Exception e ) {
			System.out.println("Erro arquivo: TituloJsonController.java no metodo: getTodosTitulos();");
			return null;
		}

		return listaTitulos;
	}

	@CrossOrigin
	@RequestMapping("/apagarTituloId={id}")
	public void deleteTituloId(@PathVariable Long id) {
		try {
			titulos.deleteById(id);
		} catch(Exception e) {
			System.out.println("Erro arquivo: TituloJsonController.java no metodo: deleteTituloId();");
		}
	}

}
