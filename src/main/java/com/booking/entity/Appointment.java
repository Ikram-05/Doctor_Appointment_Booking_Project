package com.booking.entity;



import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointment_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date appointment_date;

    @Column(nullable = false)
    private String status; // Booked, Canceled, etc.


	// Getters and Setters
    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
