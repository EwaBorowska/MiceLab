package pl.coderslab.model;

import lombok.Data;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.dao.AgeCalculator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@Entity(name = "Mouse")
@Table(name = "mouse")
public class Mouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long mousePassId;

    public enum Sex {
        MALE,
        FEMALE
    }
    private  Sex sex;

    private String KO1A;
    private String KO1B;
    private String KO1D;

    /**
     * id miotu
     */

    private Long offspringId;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private  Long motherMousePassId;
    private Long fatherMousePassId;
    private  LocalDate deathDate;
    private boolean active = true;
    private boolean available = true;
    private String comments;
    private LocalDate availabilityDate;




    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;




    public void setActiveAndAvailable(Mouse mouse) {

        if ("undefined".equals(this.getKO1A())  || "undefined".equals(this.getKO1B()) || "undefined".equals(this.getKO1D())) {
            this.setAvailable(false);
        }

        LocalDate bd = this.getBirthDate();
        LocalDate today = LocalDate.now();

        if (AgeCalculator.calculateAge1(this, bd, today) < 90) {
            this.setAvailable(false);

        }

        if (this.getDeathDate() == null) {
            this.setActive(true);
        }


    }

}
