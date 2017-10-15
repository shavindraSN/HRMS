package Mapping;
// Generated Oct 15, 2017 5:24:28 PM by Hibernate Tools 4.3.1

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 * Employee generated by hbm2java
 */
@Entity
public class Employee implements java.io.Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private int employeeid;
    private String name;
    private Integer role;
    private String rolename;

    public Employee() {
    }

    public Employee(int employeeid) {
        this.employeeid = employeeid;
    }

    public Employee(int employeeid, String name, Integer role, String rolename) {
        this.employeeid = employeeid;
        this.name = name;
        this.role = role;
        this.rolename = rolename;
    }

    public int getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return this.role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

}
