package com.andresortega.orm.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
    private int repairId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "carId", referencedColumnName = "carId",
            foreignKey = @ForeignKey(name = "fk_car"))
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId",
            foreignKey = @ForeignKey(name = "fk_customer"))
    private Customer customer;

    @Basic(optional = false)
    @JavaType(FloatJavaType.class)
    @Column(nullable = false)
    private Float price;

    @Basic(optional = false)
    @JavaType(LocalDateTimeJavaType.class)
    @Column(nullable = false)
    private LocalDateTime date;

    @Basic(optional = false)
    @JavaType(StringJavaType.class)
    @Column(length = 200, nullable = false)
    private String description;
    
    @Enumerated(EnumType.ORDINAL)
    @Basic(optional = false)
    @Column(nullable = false)
    private RepairState repairState;

    public Repair() {
        this.date = LocalDateTime.now();
        this.repairState = RepairState.PENDIENTE;
    }

    public Repair(Car car, Customer customer, Float price, String description) {
        this.car = car;
        this.customer = customer;
        this.price = price;
        this.date = LocalDateTime.now();
        this.description = description;
        this.repairState = RepairState.PENDIENTE;
    }
    
    public Repair(Car car, Customer customer, Float price, LocalDateTime date, String description, RepairState repairState) {
        this.car = car;
        this.customer = customer;
        this.price = price;
        this.date = date;
        this.description = description;
        this.repairState = repairState;
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

    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public RepairState getRepairState() {
        return repairState;
    }

    public void setRepairState(RepairState repairState) {
        this.repairState = repairState;
    }

}
