package pl.com.javasoft.emotiondiary.diary;

import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class EmotionService {

    private final EmotionRepository emotionRepository;

    private static final Logger log = LoggerFactory.getLogger(EmotionService.class);

    public EmotionService(EmotionRepository emotionRepository) {
        this.emotionRepository = emotionRepository;
    }

    public Mono<Emotions> save(EmotionCreateCommand command){
        return Mono.just(emotionRepository.save(new Emotions(null, LocalDateTime.now(),
                Collections.emptyList(),
                command.getDescription(), command.getEmotion(),command.getBehavior())));
    }

    @Transactional(readOnly = true)
    public Flux<Emotions> findAll(){
        List<Emotions> emotionsList;
        try {
            emotionsList = emotionRepository.findAll();
            log.warn("List: {}"+emotionsList.toString());
            return Flux.fromStream(emotionsList.stream()
                    .map(emotions -> new Emotions(emotions.getId(), emotions.getEntryDate(), new ArrayList<>(),emotions.getDescription(), emotions.getEmotion(), emotions.getBehavior())));
        } catch (SQLGrammarException ex){
           log.error("Lazy error {}", ex.getStackTrace());
           return Flux.error(ex);
        }

    }
}
