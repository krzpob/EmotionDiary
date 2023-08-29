package pl.com.javasoft.EmotionDiary.diary;


import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

public class Emotions implements Persistable<String> {


    @Id
    String id;
    @Column("entry_date")
    LocalDateTime entryDate;
    String thinks;
    String description;
    int emotion;
    String behavior;

    public Emotions(String id, LocalDateTime entryDate, String thinks, String description, int emotion, String behavior) {
        this.id = id;
        this.entryDate = entryDate;
        this.thinks = thinks;
        this.description = description;
        this.emotion = emotion;
        this.behavior = behavior;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return true;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public String getThinks() {
        return thinks;
    }

    public String getDescription() {
        return description;
    }

    public int getEmotion() {
        return emotion;
    }

    public String getBehavior() {
        return behavior;
    }


}
