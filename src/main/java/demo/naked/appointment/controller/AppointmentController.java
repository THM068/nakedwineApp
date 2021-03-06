package demo.naked.appointment.controller;

import demo.naked.appointment.commandObjects.AppointmentCommand;
import demo.naked.appointment.domain.Appointment;
import demo.naked.appointment.exceptions.BusinessException;
import demo.naked.appointment.services.AppointmentService;
import demo.naked.appointment.websockets.Greeting;
import demo.naked.appointment.websockets.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
import java.util.Arrays;
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
        new BusinessException("Some error");
        return "appointments/index";
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

    @ModelAttribute("planets")
    public List<String> populatePlanets() {
        return Arrays.asList(new String[]{
                "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
        });
    }
    private Appointment mapCommandToAppointment(AppointmentCommand command) {
        Appointment appointment = new Appointment();
        appointment.setLastUpdated(new Date());
        appointment.setAppointmentDate(command.getAppointmentDate());
        appointment.setDescription(command.getDescription());

        return appointment;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    @RequestMapping(value = "/hello")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(5000);
        System.out.println("Hello you");
        return new Greeting("Hello, " + message.getName() + "!");
    }


}
