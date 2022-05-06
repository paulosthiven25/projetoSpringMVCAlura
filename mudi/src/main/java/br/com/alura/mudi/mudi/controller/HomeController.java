package br.com.alura.mudi.mudi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mudi.mudi.model.Pedido;

import br.com.alura.mudi.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
	@Autowired
	private PedidoRepository pr ;
	
	@GetMapping("/home")
	public ModelAndView Home() {
		ModelAndView mv  = new ModelAndView("home");
		List<Pedido> pedidos = pr.findAll();
		mv.addObject("pedidos",pedidos);
		return mv;
		
	}

}
