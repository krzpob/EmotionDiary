package pl.com.javasoft.emotiondiary.diary;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith({MockitoExtension.class})
class EmotionServiceTest {

    @InjectMocks
    private EmotionService emotionService;

    @Mock
    private EmotionRepository emotionRepository;

    @Captor
    ArgumentCaptor<Emotions> emotionsArgumentCaptor;

    @Test
    void shouldSaveToRepoEmotion(){
        //given
        EmotionCreateCommand ecmd = new EmotionCreateCommand();
        ecmd.setBehavior("Taralala");
        ecmd.setEmotion(6);
        ecmd.setDescription("yaxa a a ax khx hagagxagsg a");

        given(emotionRepository.save(any(Emotions.class))).willReturn(
                new Emotions(1L, LocalDateTime.now(),Collections.emptyList(),
                        ecmd.getDescription(), ecmd.getEmotion(), ecmd.getBehavior())
        );

        //when
        emotionService.save(ecmd).block();
        //then
        then(emotionRepository).should().save(emotionsArgumentCaptor.capture());
        BDDAssertions.then(emotionsArgumentCaptor.getValue().getEmotion()).isEqualTo(6);
        BDDAssertions.then(emotionsArgumentCaptor.getValue().getBehavior()).isEqualTo("Taralala");
    }

}