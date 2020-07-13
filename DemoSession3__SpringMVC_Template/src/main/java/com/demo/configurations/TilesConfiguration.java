package com.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfiguration implements WebMvcConfigurer {

	@Bean
	public UrlBasedViewResolver basedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {
			"/WEB-INF/tiles/tiles.xml",
			"/WEB-INF/tiles/tiles_home.xml",
			"/WEB-INF/tiles/tiles_aboutus.xml",
			"/WEB-INF/tiles/tiles_news.xml"
		});
		return configurer;
	}

}
