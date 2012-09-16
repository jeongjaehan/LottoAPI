package com.lotto.dao;

import java.util.List;

import com.lotto.dto.LottoDTO;

public interface LottoMapper {
	public List<LottoDTO> getLottoList(LottoDTO lotto);
	public LottoDTO getLottoByNumber(LottoDTO lotto);
	public int getLottoLastestNO();
	public void insertLotto(LottoDTO lottoDTO);
}
