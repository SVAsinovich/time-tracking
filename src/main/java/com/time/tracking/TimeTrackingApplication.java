package com.time.tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@EnableJpaRepositories("com.time_tracking.*")
@ComponentScan(basePackages = { "com.time_tracking.*" })
@EntityScan("com.time_tracking.*")*/
public class TimeTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeTrackingApplication.class, args);
	}

}
