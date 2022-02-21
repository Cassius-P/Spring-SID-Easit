package fr.easit.easit.models.service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

    public Invoice(){}
    public Invoice(Date date, String path, Service service){
        this.setDate(date);
        this.setPath(path);
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

    @Column(nullable = false)
    private Date date;
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Column(nullable = false)
    private String path;
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}