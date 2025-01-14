package com.andresortega.cosas;

import com.andresortega.database.CarService;
import com.andresortega.database.CustomerService;
import com.andresortega.database.RepairService;
import com.andresortega.model.Car;
import com.andresortega.model.Customer;
import com.andresortega.model.EngineType;
import com.andresortega.model.Repair;
import java.util.List;

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
        Repair re2 = new Repair(ca, cu2, 5000.0f, "Cinturón de seguridad");
        RepairService.create(re2);
        Repair re3 = new Repair(ca2, cu, 1500.7f, "Pastillas de freno");
        RepairService.create(re3);
        Repair re4 = new Repair(ca2, cu2, 57000.0f, "Reconstrucción del motor");
        RepairService.create(re4);
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
    
    public static boolean customerExists(String dni){
        Customer customer = CustomerService.read(dni);
        
        return customer != null;
    }
    
    public static boolean carExists(String licensePlate){
        Car car = CarService.read(licensePlate);
        
        return car != null;
    }
    
    // Insertar reparación
    
    
    // Consulta historico reparaciones de coche
    
    public static List<Repair> carRepairHistory(Car car) {
        return RepairService.findByCar(car);
    }
    
    // Consulta historico reparaiones de coche
    
    
    // Consulta histórico de coches que ha reparado un cliente
    
    public static List<Repair> customerRepairHistory(Customer customer) {
        return RepairService.findByCustomer(customer);
    }
    
    // Consulta histórico de coches que ha reparado un cliente
    
    
    // Actualizar datos de cliente
    
    public static void updateCustomer(Customer customer){
        CustomerService.update(customer);
    }
    
    // Actualizar datos de cliente
    
    
    // Actualizar datos de coche
    
    public static void updateCar(Car car){
        CarService.update(car);
    }
    
    // Actualizar datos de coche
    
    
    // Actualizar datos de reparación
    
    public static void updateRepair(Repair repair){
        RepairService.update(repair);
    }
    
    // Actualizar datos de reparación
    
}
