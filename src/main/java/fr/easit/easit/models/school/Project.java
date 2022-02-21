package fr.easit.easit.models.school;

import fr.easit.easit.models.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "project")
public class Project implements Serializable {
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
    @JoinColumn( name = "teacher_id")
    private User teacher;
    public User getTeacher() {
        return teacher;
    }
    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    @ManyToOne
    @JoinColumn( name = "class_id")
    private Class classSet;
    public Class getClassSet() {
        return classSet;
    }
    public void setClassSet(Class classSet) {
        this.classSet = classSet;
    }

    private Date dueTo;
    public Date getDueTo() {
        return dueTo;
    }
    public void setDueTo(Date dueTo) {
        this.dueTo = dueTo;
    }
}