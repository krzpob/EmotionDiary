package pl.com.javasoft.EmotionDiary.diary;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface EmotionRepository extends R2dbcRepository<Emotions, String> {
}
