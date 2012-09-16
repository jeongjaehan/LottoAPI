package com.lotto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lotto.dao.LottoMapper;
import com.lotto.dto.LottoDTO;

@Service
@Transactional
public class LottoService {
	@Autowired private LottoMapper lottoMapper;
	
	public List<LottoDTO> getLottoList(LottoDTO lotto){
		return lottoMapper.getLottoList(lotto);
	}
	
	public LottoDTO getLottoByNumber(int n){
		LottoDTO lotto = new LottoDTO();
		lotto.setN(n);
		return lottoMapper.getLottoByNumber(lotto);
	}
}
