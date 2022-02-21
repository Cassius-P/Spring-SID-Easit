package fr.easit.easit.models.form;

import fr.easit.easit.models.service.ServiceSubType;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "parameter")
public class Parameter implements Serializable {

    public Parameter(){}
    public Parameter(String name, ServiceSubType serviceSubType, ParameterType parameterType){
        this.setName(name);
        this.setServiceSubType(serviceSubType);
        this.setParameterType(parameterType);
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

    @OneToOne(mappedBy = "parameter")
    private ParameterValue parameterValue;
    public ParameterValue getParameterValue() {
        return parameterValue;
    }
    public void setParameterValue(ParameterValue parameterValue) {
        this.parameterValue = parameterValue;
    }

    @ManyToOne
    @JoinColumn(name = "type_parameter_id", nullable = false)
    private ParameterType parameterType;
    public ParameterType getParameterType() {
        return parameterType;
    }
    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
    }

    @ManyToOne
    @JoinColumn(name= "sub_type_id", nullable = false)
    private ServiceSubType serviceSubType;
    public ServiceSubType getServiceSubType() {
        return serviceSubType;
    }
    public void setServiceSubType(ServiceSubType serviceSubType) {
        this.serviceSubType = serviceSubType;
    }

    @Column(length = 50, nullable = false)
    @Size(min=1, max=50)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}