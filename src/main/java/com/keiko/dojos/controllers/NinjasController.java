package com.keiko.dojos.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.keiko.dojos.models.Dojo;
import com.keiko.dojos.models.Ninja;
import com.keiko.dojos.services.DojoService;
import com.keiko.dojos.services.NinjaService;

@Controller
public class NinjasController {
	private final DojoService ds;
	private final NinjaService ns;
	
	public NinjasController(DojoService ds, NinjaService ns) {
		this.ds=ds;
		this.ns=ns;
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) { //form will know what to bind to
		model.addAttribute("allDojos", ds.findAllDojos());
		return "/ninjas/new.jsp";
	}
	
	@PostMapping("/ninjas")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {//@Valid is validations
		if(result.hasErrors()) {
			return "/ninjas/new.jsp";
		}else {
			Ninja createdNinja=ns.createNinja(ninja); //createDojo comes from Services and dojo from the parameter above
			return "redirect:/dojos/"+ createdNinja.getDojo().getId();
		}
	}
	
	
}
