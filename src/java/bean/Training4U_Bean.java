package bean;
import Data.Lesson;
import Data.Booking;
import Data.Sport;
import Data.Instructor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * @author cmpgsbyr
 */

@Named(value = "training4U_Bean")
@SessionScoped
public class Training4U_Bean implements Serializable {

    @PersistenceContext(unitName = "Training4UPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of Training4U_Bean
     */
    public Training4U_Bean() {
    }

    public List<Lesson>getLessonList() {
        return em.createNamedQuery("Lesson.findAll").getResultList();

    }
    public List<Booking>getBookingList(){
        return em.createNamedQuery("Booking.findAll").getResultList();
    }
    
    public List<Sport>getSportList(){
        return em.createNamedQuery("Sport.findAll").getResultList();
    }
    
    public List<Instructor>getInstructorList(){
        return em.createNamedQuery("Instructor.findAll").getResultList();
    }
    
    
    
}