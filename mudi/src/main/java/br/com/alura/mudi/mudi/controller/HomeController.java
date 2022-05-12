package br.com.alura.mudi.mudi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mudi.mudi.model.Pedido;
import br.com.alura.mudi.mudi.model.StatusPedido;
import br.com.alura.mudi.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private PedidoRepository pr ;
	
	@GetMapping
	public ModelAndView Home() {
		ModelAndView mv  = new ModelAndView("home");
		List<Pedido> pedidos = pr.findAll();
		mv.addObject("pedidos",pedidos);
		return mv;
		
	}
	
	@GetMapping("/{status}")
	public ModelAndView porStatus(@PathVariable ("status")String status) {
		ModelAndView mv  = new ModelAndView("home");
		List<Pedido> pedidos = pr.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		mv.addObject("pedidos",pedidos);
		mv.addObject(status,status);
		return mv;
		
	}
	@ExceptionHandler(IllegalArgumentException.class)	
	public String onError() {
		return "redirect:/home";
	}

}
