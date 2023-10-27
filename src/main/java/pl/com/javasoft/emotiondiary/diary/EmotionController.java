package pl.com.javasoft.emotiondiary.diary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class EmotionController {
    private static final Logger log = LoggerFactory.getLogger(EmotionController.class);
    final private EmotionService emotionService;

    public EmotionController(EmotionService emotionService) {
        this.emotionService = emotionService;
    }

    @PostMapping("emotions")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Emotions> insert(@Validated @RequestBody EmotionCreateCommand command) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("[REQUEST] {}",objectMapper.writeValueAsString(command));
        return emotionService.save(command);
    }

    @GetMapping("/emotions")
    public Flux<Emotions> findAll(){
        return emotionService.findAll();
    }
}
