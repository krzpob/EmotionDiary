package pl.com.javasoft.emotiondiary.diary;

import org.springframework.lang.NonNull;

import java.util.List;

public class EmotionCreateCommand {

    private String description;
    private int emotion;
    @NonNull
    private String behavior;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmotion() {
        return emotion;
    }

    public void setEmotion(int emotion) {
        this.emotion = emotion;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}
