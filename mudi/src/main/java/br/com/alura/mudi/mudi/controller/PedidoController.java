package br.com.alura.mudi.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mudi.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mudi.mudi.model.Pedido;
import br.com.alura.mudi.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	@Autowired
	private PedidoRepository pr; 
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicaoNovoPedido) {
		return "pedido/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicaoNovoPedido,BindingResult br) {
		
		if(br.hasErrors()) {
			return "pedido/formulario";
		}
		Pedido pedido = requisicaoNovoPedido.toPedido();
		pr.save(pedido);
		return "pedido/formulario";
	}
}
