package fr.easit.easit.models.form;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parameter_value")
public class ParameterValue implements Serializable {
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

    private String value;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @OneToOne
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;
    public Parameter getParameter(){
        return parameter;
    }
    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
}