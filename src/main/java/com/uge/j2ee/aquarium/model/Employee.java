package com.uge.j2ee.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmployee;
    private String name;
    private String surname;
    private String numSecSocial;
    private Date birthday;
    private String designation;
    //TO DO: COMPLETE ATTRIBUTE


    public Employee() {
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumSecSocial() {
        return numSecSocial;
    }

    public void setNumSecSocial(String numSecSocial) {
        this.numSecSocial = numSecSocial;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((designation == null) ? 0 : designation.hashCode());
        result = prime * result + ((idEmployee == null) ? 0 : idEmployee.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (designation == null) {
            if (other.designation != null)
                return false;
        } else if (!designation.equals(other.designation))
            return false;
        if (idEmployee== null) {
            if (other.idEmployee != null)
                return false;
        } else if (!idEmployee.equals(other.idEmployee))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
