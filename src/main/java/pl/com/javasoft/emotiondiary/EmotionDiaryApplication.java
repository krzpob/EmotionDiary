package pl.com.javasoft.emotiondiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EmotionDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmotionDiaryApplication.class, args);
	}

}
