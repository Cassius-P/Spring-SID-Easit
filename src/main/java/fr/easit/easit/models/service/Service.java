package fr.easit.easit.models.service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import com.vladmihalcea.hibernate.type.json.JsonType;
import fr.easit.easit.models.school.Project;
import fr.easit.easit.models.user.User;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.JSONObject;

@Entity
@Table(name = "service")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Service implements Serializable {

    public Service(){}
    public Service(ServiceSettings settings, User user, ServiceSubType serviceSubType){
        this.setSettings(settings);
        this.setUser(user);
        this.setServiceSubType(serviceSubType);
    }
    public Service(ServiceSettings settings, User user, Project project, ServiceSubType serviceSubType){
        this.setSettings(settings);
        this.setUser(user);
        this.setProject(project);
        this.setServiceSubType(serviceSubType);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", nullable = false)
    private UUID id;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    @Type(type = "json")
    @Column(columnDefinition = "json", name = "settings", nullable = false)
    private ServiceSettings settings;
    public ServiceSettings getSettings() {
        return settings;
    }
    public void setSettings(ServiceSettings settings) {
        this.settings = settings;
    }

    @OneToMany(mappedBy = "service")
    private List<Invoice> invoices;
    public List<Invoice> getInvoices() {
        return invoices;
    }
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
    public void addInvoice(Invoice invoice){
        List<Invoice> invoices = getInvoices();
        invoices.add(invoice);
        setInvoices(invoices);
    }

    @OneToMany(mappedBy = "service")
    private List<Whitelist> whitelists;
    public List<Whitelist> getWhitelists() {
        return whitelists;
    }
    public void setWhitelists(List<Whitelist> whitelists) {
        this.whitelists = whitelists;
    }
    public void addInvoice(Whitelist whitelist){
        List<Whitelist> whitelists = getWhitelists();
        whitelists.add(whitelist);
        setWhitelists(whitelists);
    }

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "sub_typ_id", nullable = false)
    private ServiceSubType serviceSubType;
    public ServiceSubType getServiceSubType() {
        return serviceSubType;
    }
    public void setServiceSubType(ServiceSubType serviceSubType) {
        this.serviceSubType = serviceSubType;
    }

    @ManyToOne
    @JoinColumn(name= "project_id", nullable = true)
    private Project project;
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
}