package fr.easit.easit.models.user;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "forgot_password")
public class ForgotPassword implements Serializable {

    public ForgotPassword(){}
    public ForgotPassword(String code, Date validUntil, User user){
        this.setCode(code);
        this.setValidUntil(validUntil);
        this.setUser(user);
    }

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
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "valid_until", nullable = false)
    private Date validUntil;
    public Date getValidUntil(){
        return validUntil;
    }
    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    @Column(length = 6, nullable = false)
    @Size(min = 6, max = 6)
    private String code;
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }


}