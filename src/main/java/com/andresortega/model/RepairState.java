package com.andresortega.model;

/**
 *
 * @author Andrés
 */
public enum RepairState {
    /**
     * The singleton instance for the day-of-week of Tuesday. This has the
     * numeric value of {@code 2}.
     */
    PENDING,
    /**
     * The singleton instance for the day-of-week of Wednesday. This has the
     * numeric value of {@code 3}.
     */
    IN_PROCESS,
    /**
     * The singleton instance for the day-of-week of Thursday. This has the
     * numeric value of {@code 4}.
     */
    COMPLETED,
    
    PICK_UP,
    
    PICKED_UP;
}
