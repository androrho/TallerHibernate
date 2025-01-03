/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andresortega.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import static jakarta.persistence.FetchType.LAZY;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.hibernate.annotations.JavaType;
import org.hibernate.type.descriptor.java.FloatJavaType;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;
import org.hibernate.type.descriptor.java.StringJavaType;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "Repairs")
public class Repair {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    int repairId;

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "carId", referencedColumnName = "carId",
            foreignKey = @ForeignKey(name = "fk_car"))
    Car car;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId",
            foreignKey = @ForeignKey(name = "fk_customer"))
    Customer customer;

    @Basic(optional = false)
    @JavaType(FloatJavaType.class)
    @Column(nullable = false)
    Float price;

    @Basic(optional = false)
    @JavaType(LocalDateTimeJavaType.class)
    @Column(nullable = false)
    LocalDateTime date;

    @Basic(optional = false)
    @JavaType(StringJavaType.class)
    @Column(length = 200, nullable = false)
    String description;

    public Repair() {
    }

    public Repair(int repairId, Car car, Customer customer, Float price, LocalDateTime date, String description) {
        this.repairId = repairId;
        this.car = car;
        this.customer = customer;
        this.price = price;
        this.date = date;
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.repairId;
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
        final Repair other = (Repair) obj;
        return this.repairId == other.repairId;
    }

}
