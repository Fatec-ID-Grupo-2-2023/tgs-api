package br.com.springboot.tgs.entities.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "consults")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_cpf")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "dentist_id", nullable = false)
    private User dentist;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "procedure_id")
    private Procedure procedure;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private User employee;

    private Boolean status;

    public Consult() {

    }

    public Consult(Integer id, Patient patient, User dentist, LocalDateTime dateTime, Procedure procedure,
            User employee, Boolean status) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.dateTime = dateTime;
        this.procedure = procedure;
        this.employee = employee;
        this.status = status;
    }

    public Consult(User dentist, LocalDateTime dateTime, User employee, Boolean status) {
        this.dentist = dentist;
        this.dateTime = dateTime;
        this.employee = employee;
        this.status = status;
    }

    // ID
    public Integer getId() {
        return id;
    }

    // PATIENT
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // DENTIST
    public User getDentist() {
        return dentist;
    }

    public void setDentist(User dentist) {
        this.dentist = dentist;
    }

    // DATE TIME
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    // PROCEDURE
    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    // EMPLOYEE
    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    // STATUS
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}