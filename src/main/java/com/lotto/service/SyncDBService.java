package com.lotto.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lotto.dao.LottoMapper;
import com.lotto.dto.LottoDTO;

@Service
@Transactional
public class SyncDBService {
	private Logger logger  = LoggerFactory.getLogger(this.getClass());
	@Autowired HttpDownloadService httpDownloadService;
	@Autowired LottoMapper lottoMapper;

	@Value(value="#{prop['download.file_path']}") private String file_path;
	@Value(value="#{prop['download.file_prefix']}") private String file_prefix;
	@Value(value="#{prop['download.file_subfix']}") private String file_subfix;

	public void syncDB() throws Exception{

		int last_n = lottoMapper.getLottoLastestNO(); // 마지막 로또 회차 조회

		HtmlCleaner hc = new HtmlCleaner();

		Date downloadDate = new Date();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd",Locale.KOREA);
		String today = formatter.format(downloadDate);

		String target_file = file_path + file_prefix + today +file_subfix;
		TagNode node = hc.clean(new File(target_file));

		TagNode[] nodes = node.getElementsByName("tr",true);	// tr 노드 추출

		for (TagNode trNode : nodes) {
			if(trNode.getChildTags().length>=19){	// tr 노드의 하위 태그 (td태그)의 사이즈가 19개 이상이것들만 추출
				List<TagNode> tdList = trNode.getChildren();	// td 노드 추출 (실제 데이터)

				int n = 0; // 회차

				if(tdList.size()==20){ // 년도가 포함되었을경우 td가 총 20개
					n = Integer.parseInt(tdList.get(1).getText().toString());	// 년도 포함일 경우 두번째 td에서 회차 정보 가져옴.
				}else if(tdList.size()==19){ // 년도 미포함 td가 총 19개
					n = Integer.parseInt(tdList.get(0).getText().toString());	// 년도 포함이 아닐경우 첫번째 td에서 회차 정보 가져옴.
				}

				if(last_n < n){ // DB에 저장된 최종 로또 회차 보다 다운로드 받은파일의 회차가 더 클경우 DB 저장
					LottoDTO lottoDTO = convertTagNodeToLottoDTO(tdList);
					lottoMapper.insertLotto(lottoDTO);
					logger.info("새로운 로또 회차 발견 [{}회차]를 DB에 추가하였습니다.",n);
					logger.info("{}회차 정보 : {}",n , lottoDTO);
				}

			}
		}
	}


	/**
	 * TagNode -> LottoDTO type 변경
	 * @param tdList
	 * @return LottoDTO
	 */
	private LottoDTO convertTagNodeToLottoDTO(List<TagNode> tdList) {

		LottoDTO lottoDTO = new LottoDTO();

		int idx = 0;

		if(tdList.size()==20) //년도 포함일경우 시작은 1부터
			idx = 1;

		//		tdList 에서 가져와서 변수 세팅 시작
		int n = Integer.parseInt(
				tdList
				.get(idx)
				.getText()
				.toString()); // 회차 
		String dd = tdList.get(++idx).getText().toString();// 추첨일
		int wc1 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); // 1등 당첨자수
		long wa1 = Long.parseLong(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); // 1등 당첨금
		int wc2 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wa2 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wc3 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wa3 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wc4 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wa4 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wc5 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wa5 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wn1 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wn2 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wn3 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wn4 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wn5 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wn6 = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		int wnb = Integer.parseInt(
				tdList.get(++idx)
				.getText()
				.toString()
				.replaceAll(",", "")); 
		//		tdList 에서 가져와서 변수 세팅 종료



		//		LottoDTO 세팅 시작
		lottoDTO.setY(
				Integer.parseInt(
						new SimpleDateFormat("yyyy",Locale.KOREA)
						.format(new Date())));
		lottoDTO.setN(n);
		lottoDTO.setDd(dd);
		lottoDTO.setWc1(wc1);
		lottoDTO.setWa1(wa1);
		lottoDTO.setWc2(wc2);
		lottoDTO.setWa2(wa2);
		lottoDTO.setWc3(wc3);
		lottoDTO.setWa3(wa3);
		lottoDTO.setWc4(wc4);
		lottoDTO.setWa4(wa4);
		lottoDTO.setWc5(wc5);
		lottoDTO.setWa5(wa5);
		lottoDTO.setWn1(wn1);
		lottoDTO.setWn2(wn2);
		lottoDTO.setWn3(wn3);
		lottoDTO.setWn4(wn4);
		lottoDTO.setWn5(wn5);
		lottoDTO.setWn6(wn6);
		lottoDTO.setWnb(wnb);
		//		LottoDTO 세팅 종료

		return lottoDTO;
	}


}
