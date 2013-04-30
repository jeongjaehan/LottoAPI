package com.lotto.service;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HttpDownloadService {
	@Value(value="#{prop['download.url']}") private String download_url;
	@Value(value="#{prop['download.file_path']}") private String file_path;
	@Value(value="#{prop['download.file_prefix']}") private String file_prefix;
	@Value(value="#{prop['download.file_subfix']}") private String file_subfix;
	
	Logger logger  = LoggerFactory.getLogger(this.getClass());

	public void download() throws Exception{
		long startIimeMillis = System.currentTimeMillis();

		Date downloadDate = new Date();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd",Locale.KOREA);
		String today = formatter.format(downloadDate);
		
		
		String target_file = file_path + file_prefix + today +file_subfix;
		
		if(System.getProperty("os.name").toUpperCase().startsWith("WINDOWS")){
			target_file = "D:/tmp/" + file_prefix + today +file_subfix;
		}
		
		logger.debug("다운로드 시작 [{}]",target_file);
		
		FileOutputStream fos = null;
		InputStream is = null;
		fos = new FileOutputStream(target_file);

		URL url = new URL(download_url);
		URLConnection urlConnection = url.openConnection();
		
		String contentType = urlConnection.getContentType();
		int contentLength = urlConnection.getContentLength();

		if (contentType.startsWith("text/") || contentLength == -1)
		{
			throw new IOException("This is not a binary file.");
		}
		
		InputStream raw = urlConnection.getInputStream();
		InputStream in = new BufferedInputStream(raw);
		byte[] data = new byte[contentLength];
		int bytesRead = 0;
		int offset = 0;
		while (offset < contentLength) {
			bytesRead = in.read(data, offset, data.length - offset);
			if (bytesRead == -1)
				break;
			offset += bytesRead;
		}
		in.close();

		if (offset != contentLength) {
			throw new IOException("Only read " + offset + " bytes; Expected " + contentLength + " bytes");
		}


		FileOutputStream out = new FileOutputStream(target_file);
		out.write(data);
		out.flush();
		out.close();

		logger.debug("다운로드 완료 [{}][{} ms]",target_file , (System.currentTimeMillis() - startIimeMillis));
	}
}
