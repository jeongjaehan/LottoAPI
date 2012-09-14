package com.lotto.dao;

import com.lotto.dto.LottoDTO;

public interface LottoMapper {
	public LottoDTO getLottoByNumber(LottoDTO lotto);
	public int getLottoLastestNO();
	public void insertLotto(LottoDTO lottoDTO);
}
