package com.lotto.control;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lotto.dto.LottoArrayList;
import com.lotto.dto.LottoDTO;

@Controller
@RequestMapping(value="/lotto")
public class LottoController {

	@RequestMapping(method=RequestMethod.GET)
	public String test(ModelMap model){
		ArrayList<LottoDTO> list = new ArrayList<LottoDTO>(); 
		for (int i=0; i<20; i++){
			LottoDTO lotto = new LottoDTO();
			lotto.setN(i);
			
			list.add(lotto);
		}
		
		LottoArrayList ltList = new LottoArrayList();
		ltList.setLottoList(list);
		model.addAttribute("result", ltList);
		return "result";
	}
}
