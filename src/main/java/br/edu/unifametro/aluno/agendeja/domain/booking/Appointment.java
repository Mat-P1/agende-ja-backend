package br.edu.unifametro.aluno.agendeja.domain.booking;

import br.edu.unifametro.aluno.agendeja.domain.BaseEntity;
import br.edu.unifametro.aluno.agendeja.domain.business.Business;
import br.edu.unifametro.aluno.agendeja.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
@Table(name = "appointments")
public class Appointment extends BaseEntity {

    @Column(name = "start")
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
    @Column(name = "end")
    private LocalDateTime end;

    @Column(name = "appointment_description", nullable = false, length = 40, updatable = false)
    private String appointmentDescription;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_table_id", updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "business_table_id", updatable = false)
    private Business business;
}
