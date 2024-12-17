/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andresortega.model.cosas;

import com.andresortega.model.EngineType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.EnumSet;

/**
 *
 * @author andres
 */

@Converter(autoApply = true)
public /*static*/ class EngineTypeConverter implements AttributeConverter<EnumSet<EngineType>, Integer> {

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
