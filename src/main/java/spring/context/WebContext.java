package spring.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.lotto.dto.ErrorDTO;
import com.lotto.dto.LottoDTO;
import com.lotto.dto.LottoDTOList;

@Configuration
@EnableWebMvc
public class WebContext {
	
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver(){
		ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
		cnvr.setOrder(1);
		
		HashMap<String,String> mediaTypes = new HashMap<String,String>();
		mediaTypes.put("json", "application/json");
		mediaTypes.put("xml", "application/xml");
		cnvr.setMediaTypes(mediaTypes);
		
		//마샬링 뷰 
		Jaxb2Marshaller  j2m = new Jaxb2Marshaller();
		j2m.setClassesToBeBound(LottoDTOList.class , LottoDTO.class, ErrorDTO.class);
		MarshallingView mv = new MarshallingView(j2m);
		
		List<View> defaultViews = new ArrayList<View>();
		defaultViews.add(new MappingJacksonJsonView());
		defaultViews.add(mv);
		
		cnvr.setDefaultViews(defaultViews);
		cnvr.setIgnoreAcceptHeader(true);
		
		return cnvr;
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		
		irvr.setOrder(2);
		irvr.setPrefix("/WEB-INF/pages/");
		irvr.setSuffix(".jsp");
		
		return irvr;
	}
	
	
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/messages/messages");
        return messageSource;
    }
}
