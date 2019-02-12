package pl.coderslab.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "mated")
public class Mated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate date;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="mothers_mouse_pass_id")
    Mouse motherMousePassId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="fathers_mouse_pass_id")
    Mouse fatherMousePassId;



}
