package com.lotto.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lotto.dto.LottoDTO;
import com.lotto.service.LottoService;

@Controller
@RequestMapping(value="/apis/1/lotto/")
@ResponseStatus(value = HttpStatus.ACCEPTED)
public class LottoController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private LottoService lottoService;
	
	@RequestMapping(value="{n}",method=RequestMethod.GET)
	public String getLotto(@PathVariable int n, ModelMap model){
		LottoDTO lotto  = lottoService.getLottoByNumber(n);
		log.info("lotto : {}",lotto.toString());
		model.addAttribute("lotto", lotto);
		return "result";
	}
}
