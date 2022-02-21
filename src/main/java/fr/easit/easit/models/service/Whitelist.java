package fr.easit.easit.models.service;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "whitelist")
public class Whitelist implements Serializable {

    public Whitelist(){}
    public Whitelist(String authorizedIP, Service service){
        this.setAuthorizedIP(authorizedIP);
        this.setService(service);
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

    @ManyToOne
    @JoinColumn(name="service_uuid", nullable = false)
    private Service service;
    public Service getService() {
        return service;
    }
    public void setService(Service service) {
        this.service = service;
    }

    @Column(length = 15, name = "authorized_ip", nullable = false)
    @Size(min = 7, max =15)
    private String authorizedIP;
    public String getAuthorizedIP() {
        return authorizedIP;
    }
    public void setAuthorizedIP(String authorizedIP) {
        this.authorizedIP = authorizedIP;
    }
}