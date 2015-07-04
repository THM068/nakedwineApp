package demo.naked.appointment.commandObjects;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thandomafela on 04/07/15.
 */
public class AppointmentCommand  {

    public AppointmentCommand(){}

    public AppointmentCommand (String description, Date appointmentDate) {
        this.appointmentDate = appointmentDate;
        this.description = description;
    }


    @NotNull(message = "Please enter a description")
    @NotBlank(message = "Please enter a description")
    private String description;

    @NotNull(message = "Please enter a date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date appointmentDate;

    private Date lastUpdated = new Date();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}
