package fr.easit.easit.models.form;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "type_parameter")
public class TypeParameter implements Serializable {

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

    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "typeParameter")
    private List<Parameter> parameters;
    public List<Parameter> getParameters() {
        return parameters;
    }
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    @Column(name = "is_multiple_value")
    private Boolean isMultipleValue;
    public Boolean getMultipleValue() {
        return isMultipleValue;
    }
    public void setMultipleValue(Boolean multipleValue) {
        isMultipleValue = multipleValue;
    }
}