package com.lotto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lotto.dao.LottoMapper;
import com.lotto.dto.LottoDTO;

@Service
@Transactional
public class LottoService {
	@Autowired private LottoMapper lottoMapper;
	
	public LottoDTO getLottoByNumber(int n){
		LottoDTO lotto = new LottoDTO();
		lotto.setN(n);
		return lottoMapper.getLottoByNumber(lotto);
	}
}
