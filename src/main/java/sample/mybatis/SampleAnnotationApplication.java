/**
 *    Copyright 2015-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package sample.mybatis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import sample.mybatis.domain.City;
import sample.mybatis.mapper.CityMapper;

@SpringBootApplication
public class SampleAnnotationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SampleAnnotationApplication.class, args);
	}

	final private CityMapper cityMapper;

	public SampleAnnotationApplication(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		for(City c:this.cityMapper.findByState("CA")) {
	    System.out.println(c);
		}
	}


  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT", "DELETE", "GET", "POST")
            .allowedHeaders("*")
            .exposedHeaders("access-control-allow-headers", "access-control-allow-methods",
                "access-control-allow-origin", "access-control-max-age", "X-Frame-Options")
            .allowCredentials(false).maxAge(3600);
      }
    };

  }
}
