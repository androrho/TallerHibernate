/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andresortega.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.Set;
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
    public int customerId;

    @NaturalId
    @Basic(optional = false)
    @Column(length = 9, nullable = false, unique = true)
    public String dni;

    @Basic(optional = false)
    @JavaType(StringJavaType.class)
    @Column(length = 45, nullable = false)
    public String name;

    @Basic(optional = false)
    @JavaType(IntegerJavaType.class)
    @Column(nullable = false)
    public int age;
    
    @OneToMany(mappedBy = "customer")
    @JoinTable(name = "Repairs",
            joinColumns = @JoinColumn(name = "repairId"),
            inverseJoinColumns = @JoinColumn(name = "customerId"),
            foreignKey = @ForeignKey(name = "RepairsToCustomer"))
    public Set<Repair> repairs;
    
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

}
