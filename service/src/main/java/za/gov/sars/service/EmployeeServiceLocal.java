/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.List;
import za.gov.sars.domain.Employee;

/**
 *
 * @author S2026987
 */
public interface EmployeeServiceLocal {
    Employee save(Employee employee);

    Employee findById(Long id);

    Employee update(Employee employee);

    void deleteAll();

    Employee deleteById(Long id);

    List<Employee> listAll();
    
    boolean isExist(Employee employee);

    long count();
    
}
