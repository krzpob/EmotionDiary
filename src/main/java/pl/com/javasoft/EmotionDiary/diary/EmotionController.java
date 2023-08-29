package pl.com.javasoft.EmotionDiary.diary;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class EmotionController {
    final private EmotionService emotionService;

    public EmotionController(EmotionService emotionService) {
        this.emotionService = emotionService;
    }

    @PostMapping("emotions")
    public Mono<Emotions> insert(@RequestBody EmotionCommand command){
        return emotionService.save(command);
    }

    @GetMapping("/emotions")
    public Flux<Emotions> findAll(){
        return emotionService.findAll();
    }
}
