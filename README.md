# Doctor Appointment Booking System

## Project Overview
The Doctor Appointment Booking System is a web-based application designed to facilitate booking appointments with doctors. The system provides interfaces for patients to book appointments, doctors to manage availability, and admins to oversee the system and manage data.

## Key Features
- **User Management:** Admin can add, remove, and manage users (patients and doctors).
- **Appointment Scheduling:** Patients can view available doctors and book appointments.
- **Doctor Availability:** Doctors can update their availability.
- **Role-Based Access:** Separate interfaces for Admin, Doctor, and Patient.
- **Appointment Tracking:** Doctors can track their appointments and view patient details.

## Technologies Used
- **Java :** Core business logic implementation.
- **Hibernate (ORM):** Database interaction and table creation.
- **Servlets and JSP:** Request handling and dynamic content rendering.
- **MySQL 5.5:** Database for storing appointment and user data.
- **Apache Tomcat 9:** Application deployment and server management.
- **Maven:** Dependency management and project build.
- **HTML/CSS:** Frontend design for the user interface.

## Database Schema
### Tables
- **Users Table:**
  - `user_id` (Primary Key)
  - `name`
  - `email_id`
  - `password`
  - `role` (Patient/Doctor/Admin)
- **Doctors Table:**
  - `doctor_id` (Primary Key)
  - `name`
  - `specialization`
  - `availability` (Available/Not Available)
- **Appointments Table:**
  - `appointment_id` (Primary Key)
  - `user_id` (Foreign Key)
  - `doctor_id` (Foreign Key)
  - `appointment_date`
  - `status` (Scheduled/Completed/Cancelled)

## Configuration
### Persistence.xml (JPA Configuration)
- Database URL: `jdbc:mysql://localhost:3306/DoctorAppointmentDB?createDatabaseIfNotExist=true`
- Driver: `com.mysql.jdbc.Driver`
- Hibernate dialect: `org.hibernate.dialect.MySQLDialect`
- Auto table creation: `hibernate.hbm2ddl.auto=update`

### Deployment
- Clone the repository from GitHub.
- Import the project into Eclipse as a Maven project.
- Configure Tomcat 9 server in Eclipse.
- Ensure MySQL 5.5 is running and accessible.
- Deploy the project on Tomcat and access the application at `http://localhost:8080/DoctorAppointmentSystem`.

## How to Run
1. Start MySQL Server.
2. Deploy the project on Tomcat 9.
3. Access the application through the browser.
4. Admin can log in to manage doctors and patients. Patients can register and book appointments.
