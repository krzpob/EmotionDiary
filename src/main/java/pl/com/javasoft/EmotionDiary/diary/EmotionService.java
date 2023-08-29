package pl.com.javasoft.EmotionDiary.diary;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EmotionService {

    private final EmotionRepository emotionRepository;

    public EmotionService(EmotionRepository emotionRepository) {
        this.emotionRepository = emotionRepository;
    }

    public Mono<Emotions> save(EmotionCommand command){
        return emotionRepository.save(new Emotions(UUID.randomUUID().toString(), LocalDateTime.now(),command.getThinks(),
                command.getDescription(), command.getEmotion(),command.getBehavior()));
    }

    public Flux<Emotions> findAll(){
        return emotionRepository.findAll();
    }
}
