package fr.easit.easit.models.form;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "parameter_value")
public class ParameterValue implements Serializable {

    public ParameterValue(){}
    public ParameterValue(String value, Parameter parameter){
        this.setValue(value);
        this.setParameter(parameter);
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

    @Column(length = 50, nullable = false)
    @Size(min = 1, max = 50)
    private String value;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @OneToOne
    @JoinColumn(name = "parameter_id", nullable = false)
    private Parameter parameter;
    public Parameter getParameter(){
        return parameter;
    }
    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
}