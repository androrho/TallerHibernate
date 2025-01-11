/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andresortega.cosas;

import com.andresortega.database.CarService;
import com.andresortega.database.CustomerService;
import com.andresortega.database.RepairService;
import com.andresortega.model.Car;
import com.andresortega.model.Customer;
import com.andresortega.model.EngineType;
import com.andresortega.model.Repair;

/**
 *
 * @author Andrés
 */
public class Actions {
    public static void insertBD(){
        Car ca = new Car();
        
        ca.setLicensePlate("7890RTY");
        ca.setBrand("Mercedes");
        ca.setModel("Clase B");
        ca.setEngineType(EngineType.HYBRID);
        
        CarService.create(ca);
        
        Car ca2 = new Car("1234TRB", "audi", "A4", EngineType.DIESEL);
        
        CarService.create(ca2);
        
        
        // customer
        
        Customer cu = new Customer("12345678Y", "Pepito", 33);
        CustomerService.create(cu);
        Customer cu2 = new Customer("98765432Z", "Juanito", 37);
        CustomerService.create(cu2);
        
        // repair
        
        Repair re = new Repair(ca, cu, 2000.0f, "Luna delantera");
        RepairService.create(re);
        Repair re2 = new Repair(ca, cu, 5000.0f, "Cinturón de seguridad");
        RepairService.create(re2);
        Repair re3 = new Repair(ca, cu2, 1500.7f, "Pastillas de freno");
        RepairService.create(re3);
    }
    
    // Insertar reparación
    
    public static void insertRepair(Repair repair, String dni, String licensePlate){
        
        if (!customerExists(dni)) {
            return;
        }
        if (!carExists(licensePlate)) {
            return;
        }
        
        Car car = CarService.read(licensePlate);
        Customer customer = CustomerService.read(dni);
        repair.setCar(car);
        repair.setCustomer(customer);
        RepairService.create(repair);
    }
    
    private static boolean customerExists(String dni){
        Customer customer = CustomerService.read(dni);
        
        return customer != null;
    }
    
    private static boolean carExists(String licensePlate){
        Car car = CarService.read(licensePlate);
        
        return car != null;
    }
    
    // Insertar reparación
    
}
