package fr.easit.easit.models.service;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "whitelist")
public class Whitelist implements Serializable {
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

    @ManyToOne
    @JoinColumn(name="service_uuid")
    private Service service;
    public Service getService() {
        return service;
    }
    public void setService(Service service) {
        this.service = service;
    }
    @Column(name = "authorized_ip")
    private String authorizedIP;
    public String getAuthorizedIP() {
        return authorizedIP;
    }
    public void setAuthorizedIP(String authorizedIP) {
        this.authorizedIP = authorizedIP;
    }
}