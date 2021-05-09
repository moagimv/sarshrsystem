/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.mb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.common.AddressType;
import za.gov.sars.common.ContactType;
import za.gov.sars.domain.Address;
import za.gov.sars.domain.Contact;
import za.gov.sars.domain.Employee;
import za.gov.sars.service.EmployeeServiceLocal;

/**
 *
 * @author S2026987
 */
@ManagedBean
@ViewScoped
public class EmployeeBean extends BaseBean<Employee> {

    @Autowired
    private EmployeeServiceLocal employeeService;
    private List<ContactType> contactType;
    private List<AddressType> addressType;
    private List<Employee> employeeList = new ArrayList<>();

    @PostConstruct
    public void init() {
        getCollections().clear();
        reset().setList(true);
        employeeList = employeeService.listAll();
        contactType = Arrays.asList(ContactType.values());
        addressType = Arrays.asList(AddressType.values());
        addCollections(employeeList);
    }

    public void addOrUpdate(Employee employee) {
        if (employee != null) {
            employee.setUpdatedBy("System User");
            employee.setUpdatedDate(new Date());
        } else {
            employee = new Employee();
            employee.setCreatedBy("System User");
            employee.setCreatedDate(new Date());
               
            Address residential = new Address();
            residential.setCreatedBy("System User");
            residential.setCreatedDate(new Date());
            residential.setAddressType(AddressType.RESIDENTIAL);
            employee.addAddress(residential);
            
            Address postal = new Address();
            postal.setCreatedBy("System User");
            postal.setCreatedDate(new Date());
            postal.setAddressType(AddressType.POSTAL);
            employee.addAddress(postal);
            
            Contact landline = new Contact();
            landline.setCreatedBy("System User");
            landline.setCreatedDate(new Date());
            landline.setContactType(ContactType.LANDLINE);
            employee.addContact(landline);
            
            Contact mobile = new Contact();
            mobile.setCreatedBy("System User");
            mobile.setCreatedDate(new Date());
            mobile.setContactType(ContactType.MOBILE);
            employee.addContact(mobile);
            //Employee 1 email address contact details
            Contact emailAddress = new Contact();
            emailAddress.setCreatedBy("System User");
            emailAddress.setCreatedDate(new Date());
            emailAddress.setContactType(ContactType.EMAIL);
            employee.addContact(emailAddress);
            
            Contact facebook = new Contact();
            facebook.setCreatedBy("System User");
            facebook.setCreatedDate(new Date());
            facebook.setContactType(ContactType.FACEBOOK);
            employee.addContact(facebook);
            
            Contact instagram = new Contact();
            instagram.setCreatedBy("System User");
            instagram.setCreatedDate(new Date());
            instagram.setContactType(ContactType.INSTAGRAM);
            employee.addContact(instagram);
            
            Contact twitter = new Contact();
            twitter.setCreatedBy("System User");
            twitter.setCreatedDate(new Date());
            twitter.setContactType(ContactType.TWITTER);
            employee.addContact(twitter);
        }
        addEntity(employee);
        reset().setAdd(true);
    }

    public void save(Employee employee) {
        if (employee.getId() != null) {
            employee.setUpdatedBy("System User");
            employee.setCreatedDate(new Date());
            employeeService.update(employee);
        } else {
            employeeService.save(employee);
        }
        this.addInformationMessage("Employee saved successfully!!!");
        refreshTable(employee);
        reset().setList(true);
    }

    public void delete(Employee employee) { 
        reset().setList(true);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
        }
        if (employee.getId() != null) {
            employeeService.deleteById(employee.getId());
        }
        this.addInformationMessage("Employee removed successfully!!!");        
    }

    public void cancel(){
        reset().setList(true);
    }
    
    public List<ContactType> getContactType() {
        return contactType;
    }

    public void setContactType(List<ContactType> contactType) {
        this.contactType = contactType;
    }

    public List<AddressType> getAddressType() {
        return addressType;
    }

    public void setAddressType(List<AddressType> addressType) {
        this.addressType = addressType;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

}
