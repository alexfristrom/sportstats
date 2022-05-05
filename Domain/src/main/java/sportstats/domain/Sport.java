package sportstats.domain;

import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
/**
 *
 * @author thomas
 * 
 */ 

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Sport implements Listable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String name;

    public Sport() {
    }

    public Sport(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
