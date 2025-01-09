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
    private int carId;

    @NaturalId
    @Basic(optional = false)
    @JavaType(StringJavaType.class)
    @Column(length = 9, nullable = false, unique = true)
    private String licensePlate;

    @Basic(optional = false)
    @JavaType(StringJavaType.class)
    @Column(length = 45, nullable = false)
    private String brand;

    @Basic(optional = false)
    @JavaType(StringJavaType.class)
    @Column(length = 45, nullable = false)
    private String model;

    @Enumerated(EnumType.ORDINAL)
    @Basic(optional = false)
    @Column(nullable = false)
    private EngineType engineType;
    
    public Car() {
    }

    public Car(String licensePlate, String brand, String model, EngineType engineType) {
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

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

}