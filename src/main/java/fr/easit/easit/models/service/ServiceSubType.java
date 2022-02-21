package fr.easit.easit.models.service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import fr.easit.easit.models.form.Parameter;

@Entity
@Table(name = "service_sub_type")
public class ServiceSubType implements Serializable {
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
    @JoinColumn(name = "type_id")
    private ServiceType serviceType;
    public ServiceType getServiceType() {
        return serviceType;
    }
    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @OneToMany(mappedBy = "serviceSubType")
    private List<Service> services;
    public List<Service> getServices() {
        return services;
    }

    @OneToMany(mappedBy = "serviceSubType")
    private List<Parameter> parameters;
    public List<Parameter> getParameters() {
        return parameters;
    }
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
    public void addParameter(Parameter parameter){
        List<Parameter> parameters = getParameters();
        parameters.add(parameter);
        setParameters(parameters);
    }
}