package com.cerner.fhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FhirDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FhirDemoApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new FHIRRestfulServer(), "/*");
		registration.setName("FHIRServlet");
		return registration;
	}

}
