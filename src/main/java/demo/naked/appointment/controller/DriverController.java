package demo.naked.appointment.controller;

import demo.naked.appointment.domain.Driver;
import demo.naked.appointment.services.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;

/**
 * Created by tm1c14 on 13/07/2015.
 */
@Controller
@RequestMapping("/driver")
public class DriverController {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @ModelAttribute(value = "allDrivers")
    public Iterable<Driver> allDrivers() {
        return driverRepository.findAll();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        return "driver/list";
    }
}
