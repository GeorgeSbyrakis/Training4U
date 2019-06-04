/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cmpgsbyr
 */
@Entity
@Table(name = "LESSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lesson.findAll", query = "SELECT l FROM Lesson l"),
    @NamedQuery(name = "Lesson.findByLessonNo", query = "SELECT l FROM Lesson l WHERE l.lessonNo = :lessonNo"),
    @NamedQuery(name = "Lesson.findByDate", query = "SELECT l FROM Lesson l WHERE l.date = :date"),
    @NamedQuery(name = "Lesson.findByStartTime", query = "SELECT l FROM Lesson l WHERE l.startTime = :startTime"),
    @NamedQuery(name = "Lesson.findByEndTime", query = "SELECT l FROM Lesson l WHERE l.endTime = :endTime"),
    @NamedQuery(name = "Lesson.findByPrice", query = "SELECT l FROM Lesson l WHERE l.price = :price")})
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LESSON_NO")
    private Integer lessonNo;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Column(name = "PRICE")
    private Integer price;
    @OneToMany(mappedBy = "instructorNo")
    private Collection<Lesson> lessonCollection;
    @JoinColumn(name = "INSTRUCTOR_NO", referencedColumnName = "LESSON_NO")
    @ManyToOne
    private Lesson instructorNo;
    @OneToMany(mappedBy = "sportNo")
    private Collection<Lesson> lessonCollection1;
    @JoinColumn(name = "SPORT_NO", referencedColumnName = "LESSON_NO")
    @ManyToOne
    private Lesson sportNo;

    public Lesson() {
    }

    public Lesson(Integer lessonNo) {
        this.lessonNo = lessonNo;
    }

    public Integer getLessonNo() {
        return lessonNo;
    }

    public void setLessonNo(Integer lessonNo) {
        this.lessonNo = lessonNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Lesson> getLessonCollection() {
        return lessonCollection;
    }

    public void setLessonCollection(Collection<Lesson> lessonCollection) {
        this.lessonCollection = lessonCollection;
    }

    public Lesson getInstructorNo() {
        return instructorNo;
    }

    public void setInstructorNo(Lesson instructorNo) {
        this.instructorNo = instructorNo;
    }

    @XmlTransient
    public Collection<Lesson> getLessonCollection1() {
        return lessonCollection1;
    }

    public void setLessonCollection1(Collection<Lesson> lessonCollection1) {
        this.lessonCollection1 = lessonCollection1;
    }

    public Lesson getSportNo() {
        return sportNo;
    }

    public void setSportNo(Lesson sportNo) {
        this.sportNo = sportNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lessonNo != null ? lessonNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) object;
        if ((this.lessonNo == null && other.lessonNo != null) || (this.lessonNo != null && !this.lessonNo.equals(other.lessonNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Lesson[ lessonNo=" + lessonNo + " ]";
    }
    
}
