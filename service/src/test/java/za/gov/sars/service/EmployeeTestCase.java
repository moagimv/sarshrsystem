/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.gov.sars.common.AddressType;
import za.gov.sars.common.ContactType;
import za.gov.sars.config.TestDataSourceConfiguration;
import za.gov.sars.domain.Address;
import za.gov.sars.domain.Contact;
import za.gov.sars.domain.Employee;
import za.gov.sars.persitence.EmployeeRepository;

/**
 *
 * @author S2026987
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDataSourceConfiguration.class)
public class EmployeeTestCase {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public EmployeeTestCase() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }    

    @Test
    public void testA() {
        //Employee 1 details
        Employee employee1 = new Employee();
        employee1.setCreatedBy("Matome Moagi");
        employee1.setCreatedDate(new Date());
        employee1.setFirstName("Mpelwane");
        employee1.setLastName("Murudi");
        employee1.setEmployeeNumber("001658");
        //Employee 1 residential address    
        Address residential1 = new Address();
        residential1.setCreatedBy("Matome Moagi");
        residential1.setCreatedDate(new Date());
        residential1.setAddressType(AddressType.RESIDENTIAL);
        residential1.setAddressLine1("155 Morganhof Estate");
        residential1.setAddressLine2("128 Bokser Street");
        residential1.setArea("Pretoria North");
        residential1.setCode("0182");
        employee1.addAddress(residential1);
        //Employee 1 postal address
        Address postal1 = new Address();
        postal1.setCreatedBy("Matome Moagi");
        postal1.setCreatedDate(new Date());
        postal1.setAddressType(AddressType.POSTAL);
        postal1.setAddressLine1("P.O Box 805");
        postal1.setArea("Pretoria North");
        postal1.setCode("0182");        
        employee1.addAddress(postal1);
        //Employee 1 landline contact details
        Contact landline1 = new Contact();
        landline1.setCreatedBy("Matome Moagi");
        landline1.setCreatedDate(new Date());
        landline1.setContactType(ContactType.LANDLINE);
        landline1.setContactDetails("0126479902");
        employee1.addContact(landline1);
        //Employee 1 mobile contact details
        Contact mobile1 = new Contact();
        mobile1.setCreatedBy("Matome Moagi");
        mobile1.setCreatedDate(new Date());
        mobile1.setContactType(ContactType.MOBILE);
        mobile1.setContactDetails("0760729198");
        employee1.addContact(mobile1);
        //Employee 1 email address contact details
        Contact emailAddress1 = new Contact();
        emailAddress1.setCreatedBy("Matome Moagi");
        emailAddress1.setCreatedDate(new Date());
        emailAddress1.setContactType(ContactType.EMAIL);
        emailAddress1.setContactDetails("mmurudi@sars.gov.za");
        employee1.addContact(emailAddress1);
        //Employee 1 doesnt have social media accounts such as (facebook, instagram and twitter)
        Contact instagram1 = new Contact();
        instagram1.setCreatedBy("Matome Moagi");
        instagram1.setCreatedDate(new Date());
        instagram1.setContactType(ContactType.INSTAGRAM);
        employee1.addContact(instagram1);
        
        Contact facebook1 = new Contact();
        facebook1.setCreatedBy("Matome Moagi");
        facebook1.setCreatedDate(new Date());
        facebook1.setContactType(ContactType.FACEBOOK);
        employee1.addContact(facebook1);
        
        Contact twitter = new Contact();
        twitter.setCreatedBy("Matome Moagi");
        twitter.setCreatedDate(new Date());
        twitter.setContactType(ContactType.TWITTER);
        employee1.addContact(twitter);
        
        employeeRepository.save(employee1);
        //Employee 2 details
        Employee employee2 = new Employee();
        employee2.setCreatedBy("Matome Moagi");
        employee2.setCreatedDate(new Date());
        employee2.setFirstName("Murithi");
        employee2.setLastName("Shai");
        employee2.setEmployeeNumber("001996");
        //Employee 2 residentail address details
        Address residential2 = new Address();
        residential2.setCreatedBy("Matome Moagi");
        residential2.setCreatedDate(new Date());
        residential2.setAddressType(AddressType.RESIDENTIAL);
        residential2.setAddressLine1("Stand No 275 Block L");
        residential2.setAddressLine2("Mandela Avenue");
        residential2.setArea("Soshanguve");
        residential2.setCode("0157");
        employee2.addAddress(residential2);
        //Employee 2 does not have postal address 
        Address postal2 = new Address();
        postal2.setCreatedBy("Matome Moagi");
        postal2.setCreatedDate(new Date());
        postal2.setAddressType(AddressType.POSTAL);
        employee2.addAddress(postal2);
               
        //Employee 2 landline contact details
        Contact landline2 = new Contact();
        landline2.setCreatedBy("Matome Moagi");
        landline2.setCreatedDate(new Date());
        landline2.setContactType(ContactType.LANDLINE);
        landline2.setContactDetails("0126479833");
        employee2.addContact(landline2);
        //Employee 2 mobile contact details
        Contact mobile2 = new Contact();
        mobile2.setCreatedBy("Matome Moagi");
        mobile2.setCreatedDate(new Date());
        mobile2.setContactType(ContactType.MOBILE);
        mobile2.setContactDetails("0658546617");
        employee2.addContact(mobile2);
        //Employee 2 email contact details
        Contact emailAddress2 = new Contact();
        emailAddress2.setCreatedBy("Matome Moagi");
        emailAddress2.setCreatedDate(new Date());
        emailAddress2.setContactType(ContactType.EMAIL);
        emailAddress2.setContactDetails("mmurithi@sars.gov.za");
        employee2.addContact(emailAddress2);
        //Employee 2 facebook contact details
        Contact facebook2 = new Contact();
        facebook2.setCreatedBy("Matome Moagi");
        facebook2.setCreatedDate(new Date());
        facebook2.setContactType(ContactType.FACEBOOK);
        facebook2.setContactDetails("Murithi Shai");
        employee2.addContact(facebook2);
        //Employee 2 instagram contact details
        Contact instagram2 = new Contact();
        instagram2.setCreatedBy("Matome Moagi");
        instagram2.setCreatedDate(new Date());
        instagram2.setContactType(ContactType.INSTAGRAM);
        instagram2.setContactDetails("murithi_shai");
        employee2.addContact(instagram2);
        //Employee 2 twitter contact details
        Contact twitter1 = new Contact();
        twitter1.setCreatedBy("Matome Moagi");
        twitter1.setCreatedDate(new Date());
        twitter1.setContactType(ContactType.TWITTER);
        twitter1.setContactDetails("murithi_shai_za");
        employee2.addContact(twitter1);
        
        employeeRepository.save(employee2); 
        
        //Employee 3 details
        Employee employee3 = new Employee();
        employee3.setCreatedBy("Matome Moagi");
        employee3.setCreatedDate(new Date());
        employee3.setFirstName("Zondy");
        employee3.setLastName("Mashamba");
        employee3.setEmployeeNumber("002020");
        //Employee 3 residentail address details
        Address residential3 = new Address();
        residential3.setCreatedBy("Matome Moagi");
        residential3.setCreatedDate(new Date());
        residential3.setAddressType(AddressType.RESIDENTIAL);
        residential3.setAddressLine1("House No 954");
        residential3.setAddressLine2("Walter Sisulu drive");
        residential3.setArea("Mamelody");
        residential3.setCode("0135");
        employee3.addAddress(residential3);
        
        Address postal3 = new Address();
        postal3.setCreatedBy("Matome Moagi");
        postal3.setCreatedDate(new Date());
        postal3.setAddressType(AddressType.POSTAL);
        postal3.setAddressLine1("P.O Box 114");
        postal3.setArea("Mamelody");
        postal3.setCode("0135");
        employee3.addAddress(postal3);
        
        //Employee 3 landline contact details
        Contact landline3 = new Contact();
        landline3.setCreatedBy("Matome Moagi");
        landline3.setCreatedDate(new Date());
        landline3.setContactType(ContactType.LANDLINE);
        landline3.setContactDetails("0126478933");
        employee3.addContact(landline3);
        //Employee 2 mobile contact details
        Contact mobile3 = new Contact();
        mobile3.setCreatedBy("Matome Moagi");
        mobile3.setCreatedDate(new Date());
        mobile3.setContactType(ContactType.MOBILE);
        mobile3.setContactDetails("0838540017");
        employee3.addContact(mobile3);
        //Employee 2 email contact details
        Contact emailAddress3 = new Contact();
        emailAddress3.setCreatedBy("Matome Moagi");
        emailAddress3.setCreatedDate(new Date());
        emailAddress3.setContactType(ContactType.EMAIL);
        emailAddress3.setContactDetails("zmashamba@sars.gov.za");
        employee3.addContact(emailAddress3);
        //Employee 3 facebook contact details
        Contact facebook3 = new Contact();
        facebook3.setCreatedBy("Matome Moagi");
        facebook3.setCreatedDate(new Date());
        facebook3.setContactType(ContactType.FACEBOOK);
        facebook3.setContactDetails("Zondy Mashamba");
        employee3.addContact(facebook3);
        //Employee 3 instagram contact details
        Contact instagram3 = new Contact();
        instagram3.setCreatedBy("Matome Moagi");
        instagram3.setCreatedDate(new Date());
        instagram3.setContactType(ContactType.INSTAGRAM);
        instagram3.setContactDetails("zondy_mashamba");
        employee3.addContact(instagram3);
        //Employee 3 twitter contact details
        Contact twitter3 = new Contact();
        twitter3.setCreatedBy("Matome Moagi");
        twitter3.setCreatedDate(new Date());
        twitter3.setContactType(ContactType.TWITTER);
        twitter3.setContactDetails("zondy_mash");
        employee3.addContact(twitter3);
        
        employeeRepository.save(employee3);   
    }
    
}
