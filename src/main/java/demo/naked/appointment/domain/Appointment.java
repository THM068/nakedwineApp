package demo.naked.appointment.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thandomafela on 03/07/15.
 */
@Entity
public class Appointment implements Comparable<Appointment> {

    public Appointment(){}

    public Appointment (String description, Date appointmentDate) {
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Please enter a description")
    private String description;

    @NotNull(message = "Please enter a date")
    private Date appointmentDate;

    private Date lastUpdated = new Date();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date date) {
        this.appointmentDate = date;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getFormattedAppointmentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        return dateFormat.format(this.appointmentDate);
    }

    @Override
    public int compareTo(Appointment o) {
        return this.appointmentDate.compareTo(o.getAppointmentDate());
    }
}
