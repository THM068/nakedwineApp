package demo.naked.appointment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by tm1c14 on 13/07/2015.
 */
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Enter driver's name")
    private String driver;

    @NotNull(message = "Enter nationality")
    private String nationality;

    @NotNull(message = "Enter a team's name")
    private String team;

    public Driver() {}

    public Driver(String driver, String nationality, String team) {
        this.setDriver(driver);
        this.setNationality(nationality);
        this.setTeam(team);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
