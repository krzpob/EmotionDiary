package pl.com.javasoft.emotiondiary.diary;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ThinkEmotionCreateCommand {
    String quote;

    @JsonCreator
    public ThinkEmotionCreateCommand(String quote) {
        this.quote = quote;
    }
}
