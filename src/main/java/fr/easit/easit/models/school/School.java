package fr.easit.easit.models.school;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "school")
public class School {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "school")
    private Set<Class> classes = new HashSet<>();


    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }

    /*public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/
}
