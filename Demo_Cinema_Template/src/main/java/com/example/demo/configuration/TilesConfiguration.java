package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfiguration implements WebMvcConfigurer{

	@Bean 
	public UrlBasedViewResolver basedViewResolver() {
		UrlBasedViewResolver basedViewResolver = new UrlBasedViewResolver();
		basedViewResolver.setViewClass(TilesView.class);
		
		return basedViewResolver;
	}
	
	@Bean
	public TilesConfigurer configurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {
				//tiles.xml
				"/WEB-INF/tiles/tiles.xml",
				"/WEB-INF/tiles/tiles_home.xml",
				"/WEB-INF/tiles/tiles_aboutus.xml",
				"/WEB-INF/tiles/tiles_schedule.xml",
				"/WEB-INF/tiles/tiles_booking.xml",
				"/WEB-INF/tiles/tiles_login.xml",
				"/WEB-INF/tiles/tiles_video.xml",
				"/WEB-INF/tiles/tiles_account.xml",
				//tilesA.xml
				"/WEB-INF/tiles/tilesA.xml",
				"/WEB-INF/tiles/tilesA_dashboard.xml",
				"/WEB-INF/tiles/tilesA_cinema.xml",
				"/WEB-INF/tiles/tilesA_movie.xml",
				"/WEB-INF/tiles/tilesA_users.xml",
				"/WEB-INF/tiles/tilesA_room.xml",
				"/WEB-INF/tiles/tilesA_seat.xml",
				"/WEB-INF/tiles/tilesA_schedule.xml",
				"/WEB-INF/tiles/tilesA_report.xml",
				"/WEB-INF/tiles/tilesA_booking.xml"
		});
		
		return configurer;
	}
}
