package com.andresortega.model;

import com.andresortega.model.cosas.EngineTypeConverter;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import org.hibernate.annotations.JavaType;
import org.hibernate.annotations.NaturalId;
import org.hibernate.type.descriptor.java.StringJavaType;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "Cars")
class Car {

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

    @Convert(converter = EngineTypeConverter.class)
    @Basic(optional = false)
    @Column(nullable = false)
    EngineType engineType;

    
    @OneToMany(mappedBy = "car")
    @JoinTable(name = "Repairs",
            joinColumns = @JoinColumn(name = "repairId"),
            inverseJoinColumns = @JoinColumn(name = "carId"),
            foreignKey = @ForeignKey(name = "RepairsToCar"))
    Set<Repair> repairs;
    
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

    @Converter(autoApply = true)
    public static class EnumSetConverter implements AttributeConverter<EnumSet<EngineType>, Integer> {

        @Override
        public Integer convertToDatabaseColumn(EnumSet<EngineType> enumSet) {
            int encoded = 0;
            var values = EngineType.values();
            for (int i = 0; i < values.length; i++) {
                if (enumSet.contains(values[i])) {
                    encoded |= 1 << i;
                }
            }
            return encoded;
        }

        @Override
        public EnumSet<EngineType> convertToEntityAttribute(Integer encoded) {
            var set = EnumSet.noneOf(EngineType.class);
            var values = EngineType.values();
            for (int i = 0; i < values.length; i++) {
                if (((1 << i) & encoded) != 0) {
                    set.add(values[i]);
                }
            }
            return set;
        }
    }

}
