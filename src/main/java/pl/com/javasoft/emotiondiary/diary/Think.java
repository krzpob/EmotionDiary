package pl.com.javasoft.emotiondiary.diary;

import jakarta.persistence.*;

@Entity
@Table(name = "thinks")
public class Think {

    protected Think() {
    }

    public  Think(ThinkEmotionCreateCommand command){
        this(null,command.quote);
    }
    @Id
    Integer id;

    @ManyToOne(targetEntity = Emotions.class)
    Emotions emotion;
    String quote;

    private Think(Integer id, String quote) {
        this();
        this.id = id;
        this.quote = quote;
    }


}
