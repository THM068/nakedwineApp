package demo.naked.appointment.services;

import demo.naked.appointment.domain.Appointment;
import demo.naked.appointment.exceptions.BusinessException;

import java.util.List;
import java.util.Map;

/**
 * Created by thandomafela on 03/07/15.
 */
public interface AppointmentService {

    public List<Appointment> getAllAppointments();

    public void saveOrUpdate(Appointment appointment) throws BusinessException;

    public void delete(Appointment appointment) throws BusinessException;

    public Appointment findOne(long id);

    public List<Appointment> getAllAppointments(Map<String,Object> sortAndPageMap);


}
