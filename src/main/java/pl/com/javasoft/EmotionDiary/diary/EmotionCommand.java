package pl.com.javasoft.EmotionDiary.diary;

public class EmotionCommand {

    String thinks;
    String description;
    int emotion;
    String behavior;

    public String getThinks() {
        return thinks;
    }

    public void setThinks(String thinks) {
        this.thinks = thinks;
    }

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
