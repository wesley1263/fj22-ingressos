package br.com.caelum.ingresso.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.form.SessaoForm;
import br.com.caelum.ingresso.validacao.GerenciadorDeSessao;

@Controller
public class SessaoController {
	
	@Autowired
	private FilmeDao filme;
	@Autowired
	private SalaDao salaDao;
	
	@Autowired
	private SessaoDao session;
	
	@GetMapping("admin/sessao")
	public ModelAndView formulario(@RequestParam("salaId") Integer salaId, SessaoForm sessaoForm){
		
		sessaoForm.setSalaId(salaId);
		
		ModelAndView mav = new ModelAndView("sessao/sessao");
		
		List<Filme> filmes = filme.findAll();
		
		
		mav.addObject("form",sessaoForm);
		mav.addObject("filmes",filmes);	
		
		mav.addObject("sala",salaDao.findOne(salaId));
		
		return mav;
	}
	
	
	@Transactional
	@PostMapping("admin/sessao")
	public ModelAndView salvar(@Valid SessaoForm form, BindingResult result){
		
		Integer salaId = form.getSalaId();
		
		if(result.hasErrors()){
			return formulario(salaId,form);
		}
		
		 Sessao sessao = form.toSessao(filme, salaDao);
		 
		 Sala s = salaDao.findOne(salaId);
		 
		 GerenciadorDeSessao  valida = new GerenciadorDeSessao(session.findAllBySala(s));
		 
		 if(valida.cabe(sessao)){
			 session.save(sessao);
			 return new ModelAndView(String.format("redirect:/admin/sala/%d/sessoes/", form.getSalaId()));
		 }
		 
		 
		 return formulario(salaId, form);
	}
	
	
//	@GetMapping("admin/sala/{id}/sessoes")
//	public ModelAndView listaSessao(@PathVariable("id") Integer id){
//		
//		Sala s = sala.findOne(id);
//		ModelAndView mav = new ModelAndView("sessao/lista");
//		
//		mav.addObject("sessoes",session.findAllBySala(s));
//		mav.addObject("sala",s);
//		
//		return mav;
//	}

}
