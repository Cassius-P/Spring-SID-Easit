package fr.easit.easit.models.school;

import fr.easit.easit.models.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "school")
public class School {

    public School(){}
    public School(String name){
        this.setName(name);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 50, nullable = false)
    @Size(min=1, max=50)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "school")
    private Set<Class> classes = new HashSet<>();
    public Set<Class> getClasses() {
        return classes;
    }
    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }

    @ManyToMany(mappedBy = "schools")
    private List<User> usersFromSchool;
    public List<User> getUsers() {
        return usersFromSchool;
    }
    public void setUsers(List<User> users) {
        this.usersFromSchool = users;
    }
}
