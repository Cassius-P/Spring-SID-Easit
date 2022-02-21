package fr.easit.easit.models.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /*@OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();*/

    private String type;
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/
}
