package fr.easit.easit.models.school;

import fr.easit.easit.models.service.Service;
import fr.easit.easit.models.user.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "project")
public class Project implements Serializable {

    public Project(){}
    public Project(String name, String description, User teacher, Class aClass, Date dueTo){
        this.setName(name);
        this.setDescription(description);
        this.setTeacher(teacher);
        this.setClassSet(aClass);
        this.setDueTo(dueTo);
    }

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID id;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn( name = "teacher_id", nullable = false)
    private User teacher;
    public User getTeacher() {
        return teacher;
    }
    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    @ManyToOne
    @JoinColumn( name = "class_id", nullable = false)
    private Class classSet;
    public Class getClassSet() {
        return classSet;
    }
    public void setClassSet(Class classSet) {
        this.classSet = classSet;
    }

    @Column(length = 50, nullable = false)
    @Size(min = 1, max = 50)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Column(length = 512)
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "project")
    private List<Service> services;
    public List<Service> getServices() {
        return services;
    }

    @Column(nullable = false)
    private Date dueTo;
    public Date getDueTo() {
        return dueTo;
    }
    public void setDueTo(Date dueTo) {
        this.dueTo = dueTo;
    }
}