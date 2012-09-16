package com.lotto.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="result")
public class LottoDTOList {
	private List<LottoDTO> lottoList;

	public List<LottoDTO> getLottoList() {
		return lottoList;
	}

	@XmlElement(name="lotto")
	public void setLottoList(List<LottoDTO> lottoList) {
		this.lottoList = lottoList;
	}
	
}
