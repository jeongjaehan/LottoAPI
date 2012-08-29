package com.lotto.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="result")
public class LottoArrayList {
	private ArrayList<LottoDTO> lottoList;

	public ArrayList<LottoDTO> getLottoList() {
		return lottoList;
	}

	@XmlElement(name="lotto")
	public void setLottoList(ArrayList<LottoDTO> lottoList) {
		this.lottoList = lottoList;
	}
	
}
