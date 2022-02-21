package fr.easit.easit.models.service;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "service_type")
public class ServiceType implements Serializable {

    public ServiceType(){}
    public ServiceType(String name, String description){
        this.setName(name);
        this.setDescription(description);
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

    @OneToMany(mappedBy = "serviceType")
    private List<ServiceSubType> serviceSubTypes;
    public List<ServiceSubType> getServicesSubTypesList() {
        return serviceSubTypes;
    }
    public void setServicesSubTypesList(List<ServiceSubType> servicesSubTypesList) {
        this.serviceSubTypes = servicesSubTypesList;
    }
    public void addServiceSubType(ServiceSubType serviceSubType){
        List<ServiceSubType> serviceSubTypes = getServicesSubTypesList();
        serviceSubTypes.add(serviceSubType);
        setServicesSubTypesList(serviceSubTypes);
    }

    @Column(length = 50, nullable = false)
    @Size(min =1, max = 50)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Lob
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}