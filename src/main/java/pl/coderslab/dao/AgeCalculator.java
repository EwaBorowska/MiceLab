package pl.coderslab.dao;

import pl.coderslab.model.Mouse;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class AgeCalculator {

    public static long calculateAge1(Mouse mouse, LocalDate birthDate, LocalDate currentDate) {
        if ((mouse.getBirthDate() != null) && (currentDate != null)) {
             long mouseAge = ChronoUnit.DAYS.between(mouse.getBirthDate(), currentDate);

            return mouseAge;
        } else {
            return 0;
        }
    }


}
