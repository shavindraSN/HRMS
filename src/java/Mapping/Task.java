package Mapping;
// Generated Oct 15, 2017 5:24:28 PM by Hibernate Tools 4.3.1

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 * Task generated by hbm2java
 */
@Entity
public class Task implements java.io.Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private int taskid;
    private String description;
    private Integer employee;
    private String empname;

    public Task() {
    }

    public Task(int taskid) {
        this.taskid = taskid;
    }

    public Task(int taskid, String description, Integer employee, String empname) {
        this.taskid = taskid;
        this.description = description;
        this.employee = employee;
        this.empname = empname;
    }

    public int getTaskid() {
        return this.taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEmployee() {
        return this.employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    public String getEmpname() {
        return this.empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

}
