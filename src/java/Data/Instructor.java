/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cmpgsbyr
 */
@Entity
@Table(name = "INSTRUCTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByInstructorNo", query = "SELECT i FROM Instructor i WHERE i.instructorNo = :instructorNo"),
    @NamedQuery(name = "Instructor.findByInstructorName", query = "SELECT i FROM Instructor i WHERE i.instructorName = :instructorName"),
    @NamedQuery(name = "Instructor.findByInstructorPhone", query = "SELECT i FROM Instructor i WHERE i.instructorPhone = :instructorPhone"),
    @NamedQuery(name = "Instructor.findByInstructorEmail", query = "SELECT i FROM Instructor i WHERE i.instructorEmail = :instructorEmail")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSTRUCTOR_NO")
    private Integer instructorNo;
    @Size(max = 30)
    @Column(name = "INSTRUCTOR_NAME")
    private String instructorName;
    @Size(max = 30)
    @Column(name = "INSTRUCTOR_PHONE")
    private String instructorPhone;
    @Size(max = 30)
    @Column(name = "INSTRUCTOR_EMAIL")
    private String instructorEmail;

    public Instructor() {
    }

    public Instructor(Integer instructorNo) {
        this.instructorNo = instructorNo;
    }

    public Integer getInstructorNo() {
        return instructorNo;
    }

    public void setInstructorNo(Integer instructorNo) {
        this.instructorNo = instructorNo;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorPhone() {
        return instructorPhone;
    }

    public void setInstructorPhone(String instructorPhone) {
        this.instructorPhone = instructorPhone;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructorNo != null ? instructorNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.instructorNo == null && other.instructorNo != null) || (this.instructorNo != null && !this.instructorNo.equals(other.instructorNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Instructor[ instructorNo=" + instructorNo + " ]";
    }
    
}
