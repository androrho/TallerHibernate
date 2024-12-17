/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andresortega.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.EnumSet;

/**
 *
 * @author andres
 */
public enum EngineType {
    /**
     * The singleton instance for the day-of-week of Monday. This has the
     * numeric value of {@code 1}.
     */
    PETROL,
    /**
     * The singleton instance for the day-of-week of Tuesday. This has the
     * numeric value of {@code 2}.
     */
    DIESEL,
    /**
     * The singleton instance for the day-of-week of Wednesday. This has the
     * numeric value of {@code 3}.
     */
    ELECTRIC,
    /**
     * The singleton instance for the day-of-week of Thursday. This has the
     * numeric value of {@code 4}.
     */
    HYBRID;
    /**
     * Private cache of all the constants.
     */
    private static final EngineType[] ENUMS = EngineType.values();

    public static EngineType of(int engineType) {
        if (engineType < 1 || engineType > 5) {
            throw new NullPointerException("Invalid value for EngineType: " + engineType);
        }
        return ENUMS[engineType - 1];
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
