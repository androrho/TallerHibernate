package com.andresortega.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import org.hibernate.annotations.JavaType;
import org.hibernate.annotations.NaturalId;
import org.hibernate.type.descriptor.java.StringJavaType;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    int carId;

    @NaturalId
    @Basic(optional = false)
    @JavaType(StringJavaType.class)
    @Column(length = 9, nullable = false, unique = true)
    String licensePlate;

    @Basic(optional = false)
    @JavaType(StringJavaType.class)
    @Column(length = 45, nullable = false)
    String brand;

    @Basic(optional = false)
    @JavaType(StringJavaType.class)
    @Column(length = 45, nullable = false)
    String model;

    @Enumerated(EnumType.ORDINAL)
    @Basic(optional = false)
    @Column(nullable = false)
    EngineType engineType;
    
    public Car() {
    }

    public Car(int carId, String licensePlate, String brand, String model, EngineType engineType) {
        this.carId = carId;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.engineType = engineType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.licensePlate);
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
        final Car other = (Car) obj;
        return Objects.equals(this.licensePlate, other.licensePlate);
    }
    
}