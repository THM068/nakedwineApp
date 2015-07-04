package demo.naked.appointment.config;

import demo.naked.appointment.domain.Appointment;
import demo.naked.appointment.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by thandomafela on 03/07/15.
 */
@Component
public class BootStrap implements CommandLineRunner {

    @Autowired
    private AppointmentService appointmentService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrapping domain model ....");
        Date now = new Date();

        String [] descriptionList = {"Doctor", "Dentist" , "Football Practise"};
        int [] days = { -1, 2 , 3};

        for(int x =0; x < days.length; x++) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, days[x]);
            Date date = cal.getTime();

            Appointment appointment = new Appointment(descriptionList[x], date);
            appointment.setLastUpdated(new Date());
            appointmentService.saveOrUpdate(appointment);
        }



    }
}
