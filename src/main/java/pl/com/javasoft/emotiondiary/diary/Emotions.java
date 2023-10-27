package pl.com.javasoft.emotiondiary.diary;


import jakarta.annotation.Generated;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.jooq.impl.QOM;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "emotions")
public class Emotions implements Serializable {

    public Emotions() {
    }



    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "entry_date")
    @CreatedDate
    private LocalDateTime entryDate;

    @OneToMany()
    @JoinColumn(name = "emotion_id",nullable = true)
    private List<Think> thinks = new ArrayList<>();

    private String description;
    private int emotion;
    private String behavior;

    public Emotions(Long id, LocalDateTime entryDate, List<Think> thinks, String description, int emotion, String behavior) {
        this.id = id;
        this.entryDate = entryDate;
        this.thinks = thinks;
        this.description = description;
        this.emotion = emotion;
        this.behavior = behavior;
    }

    public Long getId() {
        return id;
    }


    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public List<Think> getThinks() {
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

    @Override
    public String toString() {
        return "Emotions{" +
                "id=" + id +
                ", entryDate=" + entryDate +
                ", thinks=" + thinks +
                ", description='" + description + '\'' +
                ", emotion=" + emotion +
                ", behavior='" + behavior + '\'' +
                '}';
    }
}
