package demo.naked.appointment.controller;

import demo.naked.appointment.commandObjects.AppointmentCommand;
import demo.naked.appointment.domain.Appointment;
import demo.naked.appointment.exceptions.BusinessException;
import demo.naked.appointment.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by thandomafela on 03/07/15.
 */

@Controller
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/appointments";
    }

    @RequestMapping(value = "/appointments")
    public String list(){

        return Views.APPOINTMENT_LIST;
    }


    @RequestMapping(value = "/appointments/tutorial")
    public String tutorial(){

        return Views.APPOINTMENT_TUTORIAL;
    }


    @RequestMapping(value = "/appointment/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute AppointmentCommand appointmentCommand, BindingResult bindingResult, RedirectAttributes redirectAttrs) {

        if(bindingResult.hasErrors()) {
            System.out.println("Appointment has errors .....");
            return Views.APPOINTMENT_LIST;
        }

        try {
            Appointment appointment = mapCommandToAppointment(appointmentCommand);
            this.appointmentService.saveOrUpdate(appointment);
            redirectAttrs.addFlashAttribute("successMessage", "Appointment Added");
        }
        catch (BusinessException bex) {
            String errorMessage = bex.getMessage();
            redirectAttrs.addFlashAttribute("errorMessage", errorMessage);
        }

        return "redirect:/appointments";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @ModelAttribute(value = "allAppointments")
    public List<Appointment> appointmentList() {
        List<Appointment> list = appointmentService.getAllAppointments();
        return list;
    }

    @ModelAttribute(value = "appointmentCommand")
    public AppointmentCommand appointmentCommand() {
        AppointmentCommand appointmentCommand = new AppointmentCommand();
        return appointmentCommand;
    }

    private Appointment mapCommandToAppointment(AppointmentCommand command) {
        Appointment appointment = new Appointment();
        appointment.setLastUpdated(new Date());
        appointment.setAppointmentDate(command.getAppointmentDate());
        appointment.setDescription(command.getDescription());

        return appointment;
    }


}
