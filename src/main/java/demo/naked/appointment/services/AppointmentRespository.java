package demo.naked.appointment.services;

import demo.naked.appointment.domain.Appointment;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by thandomafela on 03/07/15.
 */
public interface AppointmentRespository extends PagingAndSortingRepository<Appointment, Long> {


}
