package demo.naked.appointment.services;

import demo.naked.appointment.domain.Driver;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by tm1c14 on 13/07/2015.
 */

public interface DriverRepository extends PagingAndSortingRepository<Driver,Long> {
}
