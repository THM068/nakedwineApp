package demo.naked.appointment.services;

import demo.naked.appointment.domain.Appointment;
import demo.naked.appointment.exceptions.BusinessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import demo.naked.appointment.utils.CONS;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Created by thandomafela on 03/07/15.
 */
@Component(value = "appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRespository appointmentRespository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRespository appointmentRespository) {
        this.appointmentRespository = appointmentRespository;
    }

    public List<Appointment> getAllAppointments(Map<String,Object> sortAndPageMap) {
        Pageable pageable = null;
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        Iterable<Appointment> iterable = null;

        Object pObject = sortAndPageMap!=null ? sortAndPageMap.get(CONS.PAGEABLE) : null;
        if(pObject!=null && pObject instanceof Pageable) {
            pageable = (Pageable) pObject;

            iterable = appointmentRespository.findAll(pageable);

        }
        else {
            iterable = appointmentRespository.findAll();
        }

        appointmentList = IteratorUtils.toList(iterable.iterator());
        return appointmentList;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        Iterable<Appointment> iterable = appointmentRespository.findAll();
        appointmentList = IteratorUtils.toList(iterable.iterator());

        return appointmentList;
    }

    @Override
    public void saveOrUpdate(Appointment appointment) throws BusinessException {
        if(appointment == null) {
            throw new BusinessException("Appointment is not valid : null value provided");
        }

        appointmentRespository.save(appointment);
    }

    @Override
    public void delete(Appointment appointment) throws BusinessException {
        if(appointment == null) {
            throw new BusinessException("Appointment is not valid : null value provided");
        }
        appointmentRespository.delete(appointment);

    }

    @Override
    public Appointment findOne(long id) {
        Appointment appointment = appointmentRespository.findOne(id);
        return appointment;
    }
}
