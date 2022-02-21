package fr.easit.easit.models.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "forgot_password")
public class ForgotPassword implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "valid_until")
    private Date validUntil;
    public Date getValidUntil(){
        return validUntil;
    }
    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    private String code;
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }


}