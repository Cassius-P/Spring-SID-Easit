package fr.easit.easit.models.user;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "state")
public class State implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}