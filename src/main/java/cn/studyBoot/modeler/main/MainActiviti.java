package cn.studyBoot.modeler.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.studyBoot.modeler.explorer.JsonpCallbackFilter;

@ComponentScan({"cn.studyBoot","org.activiti.rest.diagram"})
@EnableAsync

@SpringBootApplication
@EnableAutoConfiguration(exclude = {     
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
})
public class MainActiviti extends WebMvcConfigurerAdapter {

	//整合activiti所需要的filter
	@Bean
	public JsonpCallbackFilter filter(){
	    return new JsonpCallbackFilter();
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainActiviti.class, args);
	}
}
