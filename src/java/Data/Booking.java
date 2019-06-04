/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cmpgsbyr
 */
@Entity
@Table(name = "BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingNo", query = "SELECT b FROM Booking b WHERE b.bookingNo = :bookingNo"),
    @NamedQuery(name = "Booking.findByCustomerName", query = "SELECT b FROM Booking b WHERE b.customerName = :customerName"),
    @NamedQuery(name = "Booking.findByCustomerPhone", query = "SELECT b FROM Booking b WHERE b.customerPhone = :customerPhone")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKING_NO")
    private Integer bookingNo;
    @Size(max = 25)
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Column(name = "CUSTOMER_PHONE")
    private BigInteger customerPhone;
    @OneToMany(mappedBy = "lessonNo")
    private Collection<Booking> bookingCollection;
    @JoinColumn(name = "LESSON_NO", referencedColumnName = "BOOKING_NO")
    @ManyToOne
    private Booking lessonNo;

    public Booking() {
    }

    public Booking(Integer bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Integer getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(Integer bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigInteger getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(BigInteger customerPhone) {
        this.customerPhone = customerPhone;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    public Booking getLessonNo() {
        return lessonNo;
    }

    public void setLessonNo(Booking lessonNo) {
        this.lessonNo = lessonNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingNo != null ? bookingNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingNo == null && other.bookingNo != null) || (this.bookingNo != null && !this.bookingNo.equals(other.bookingNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Booking[ bookingNo=" + bookingNo + " ]";
    }
    
}
