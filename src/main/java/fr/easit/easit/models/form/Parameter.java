package fr.easit.easit.models.form;

import fr.easit.easit.models.service.ServiceSubType;
import fr.easit.easit.models.user.ForgotPassword;
import fr.easit.easit.models.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parameter")
public class Parameter implements Serializable {
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
    @JoinColumn(name = "type_parameter_id")
    private TypeParameter typeParameter;
    public TypeParameter getTypeParameter() {
        return typeParameter;
    }

    @ManyToOne
    @JoinColumn(name= "sub_type_id")
    private ServiceSubType serviceSubType;
    public ServiceSubType getServiceSubType() {
        return serviceSubType;
    }
    public void setServiceSubType(ServiceSubType serviceSubType) {
        this.serviceSubType = serviceSubType;
    }

    public void setTypeParameter(TypeParameter typeParameter) {
        this.typeParameter = typeParameter;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}