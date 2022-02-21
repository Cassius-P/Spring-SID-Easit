package fr.easit.easit.models.school;

import fr.easit.easit.models.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "class")
public class Class {


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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
    public School getSchool() {
        return school;
    }
    public void setSchool(School school) {
        this.school = school;
    }

    @ManyToMany(mappedBy = "classSet")
    private List<User> users;
    public List<User> getUsers(){
        return users;
    }
    public void setUsers(List<User> users){
        this.users = users;
    }
    public void addUser(User user){
        List<User> users = getUsers();
        users.add(user);
        setUsers(users);
    }

    @OneToMany(mappedBy = "classSet")
    private List<Project> projects;
    public List<Project> getProjects() {
        return projects;
    }
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    public void addProject(Project project){
        List<Project> projects = getProjects();
        projects.add(project);
        setProjects(projects);
    }
}
