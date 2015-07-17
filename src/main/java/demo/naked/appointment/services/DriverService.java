package demo.naked.appointment.services;

import demo.naked.appointment.domain.Driver;

import java.util.List;

/**
 * Created by tm1c14 on 13/07/2015.
 */
public interface DriverService {

    public List<Driver> getAllDrivers();

    public void delete(long id);
}
