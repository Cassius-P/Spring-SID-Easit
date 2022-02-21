package fr.easit.easit.models.user;



import fr.easit.easit.models.school.Class;
import fr.easit.easit.models.school.Project;
import fr.easit.easit.models.school.School;
import fr.easit.easit.models.service.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "living_address_id")
    private Address livingAddress;
    public Address getLivingAddress() {
        return livingAddress;
    }
    public void setLivingAddress(Address livingAddress) {
        this.livingAddress = livingAddress;
    }

    @OneToOne
    @JoinColumn(name = "invoice_address_id")
    private Address invoiceAddress;
    public Address getInvoiceAddress() {
        return invoiceAddress;
    }
    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    @ManyToMany
    @JoinTable(name = "user_class",
            inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name="class_id", referencedColumnName = "id"))
    private Set<Class> classSet;
    public Set<Class> getClassSet(){
        return classSet;
    }
    public void setClassSet(Set<Class> classSet) {
        this.classSet = classSet;
    }

    @ManyToMany
    @JoinTable(name = "user_school",
            inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name="school_id", referencedColumnName = "id"))
    private Set<School> schools;
    public Set<School> getSchools() {
        return schools;
    }
    public void setSchools(Set<School> schools) {
        this.schools = schools;
    }
    public void addSchool(School school){
        Set<School> schools = getSchools();
        schools.add(school);
        setSchools(schools);
    }

    @ManyToOne
    @JoinColumn(name= "role_id")
    private Role role;
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name= "state_id")
    private State state;
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(mappedBy = "user")
    private ForgotPassword forgotPassword;
    public ForgotPassword getForgotPassword() {
        return forgotPassword;
    }
    public void setForgotPassword(ForgotPassword forgotPassword) {
        this.forgotPassword = forgotPassword;
    }

    @OneToMany(mappedBy = "user")
    private List<Service> services;
    public List<Service> getServices() {
        return services;
    }
    public void setServices(List<Service> services) {
        this.services = services;
    }
    public void addService(Service service){
        List<Service> services = getServices();
        services.add(service);
        setServices(services);
    }

    @OneToMany(mappedBy = "teacher")
    private List<Project> projects;
    public List<Project> getProjects() {
        return projects;
    }
    public void setProjects(List<Project> services) {
        this.projects = services;
    }
    public void addProject(Project project){
        List<Project> projects = getProjects();
        projects.add(project);
        setProjects(projects);
    }

    @Column(name = "first_name")
    private String firstName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String password;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String phone;
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "last_login")
    private Date lastLogin;
    public Date getLastLogin() {
        return lastLogin;
    }
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    private Boolean validated;
    public Boolean getValidated() {
        return validated;
    }
    public void setValidated(Boolean validated) {
        this.validated = validated;
    }
}