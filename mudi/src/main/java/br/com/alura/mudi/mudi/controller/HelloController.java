package br.com.alura.mudi.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String Hello(Model m) {
		m.addAttribute("nome","Mundo");
		return "hello";
	}
}



