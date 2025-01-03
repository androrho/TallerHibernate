package com.andresortega.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import org.hibernate.annotations.JavaType;
import org.hibernate.annotations.NaturalId;
import org.hibernate.type.descriptor.java.IntegerJavaType;
import org.hibernate.type.descriptor.java.StringJavaType;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int customerId;

    @NaturalId
    @Basic(optional = false)
    @Column(length = 9, nullable = false, unique = true)
    private String dni;

    @Basic(optional = false)
    @JavaType(StringJavaType.class)
    @Column(length = 45, nullable = false)
    private String name;

    @Basic(optional = false)
    @JavaType(IntegerJavaType.class)
    @Column(nullable = false)
    private int age;
    
    public Customer() {
    }

    public Customer(String dni, String name, int age) {
        this.dni = dni;
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        return Objects.equals(this.dni, other.dni);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
