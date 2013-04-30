package test.lotto;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lotto.dao.LottoMapper;
import com.lotto.dto.LottoDTO;
import com.lotto.service.HttpDownloadService;
import com.lotto.service.LottoService;
import com.lotto.service.SyncDBService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/context.xml")
public class TestDownload {
	@Value(value="#{prop['download.url']}") private String download_url;
	@Value(value="#{prop['download.file_path']}") private String file_path;
	@Value(value="#{prop['download.file_prefix']}") private String file_prefix;
	@Value(value="#{prop['download.file_subfix']}") private String file_subfix;
	
	
	@Autowired HttpDownloadService httpDownloadService;
	@Autowired SyncDBService syncDBService; 
	@Autowired LottoMapper lottoMapper;
	
	
	
//	@Test
	public void testDownload()throws Exception{
		httpDownloadService.download();
		
	}
	
//	@Test
	public void testJxl() throws Exception{
		
	}
	
//	@Test
	public void testServiceSyncDB() throws Exception{
		syncDBService.syncDB();
	}
	
	@Test
	public void lastLottoNumber() throws Exception{
		lottoMapper.getLottoLastestNO();
	}

	
	Logger logger  = LoggerFactory.getLogger(this.getClass());
}
