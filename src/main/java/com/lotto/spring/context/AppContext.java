package com.lotto.spring.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({
	"classpath:/context.xml",
	"classpath:/context-servlet.xml"
})
public class AppContext {

}
