package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.business.custom.CustomerBO;
import lk.ijse.dep.rcrmoto.dao.CustomerDAO;
import lk.ijse.dep.rcrmoto.dto.CustomerDTO;
import lk.ijse.dep.rcrmoto.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class CustomerBOImpl implements CustomerBO {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public void saveCustomer(CustomerDTO customer)  {
            customerDAO.save(new Customer(customer.getCustomerId(),customer.getName(),customer.getContact()));
    }

    @Override
    public void updateCustomer(CustomerDTO customer)  {
            customerDAO.save(new Customer(customer.getCustomerId(),customer.getName(),customer.getContact()));
    }

    @Override
    public void deleteCustomer(String id)  {
            customerDAO.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CustomerDTO> findAllCustomers()  {
            List<Customer> all = customerDAO.findAll();
            List<CustomerDTO> customerDTOS = new ArrayList<>();
            for (Customer customer : all) {
                customerDTOS.add(new CustomerDTO(customer.getCustomerId(),customer.getName(),customer.getContact()));
            }
            return customerDTOS;
    }

    @Transactional(readOnly = true)
    @Override
    public String getLastCustomerId()  {
             return customerDAO.getLastCustomerId();
    }

    @Transactional(readOnly = true)
    @Override
    public List<CustomerDTO> searchCustomer(String text)  {
            List<Customer> search = customerDAO.searchCustomers(text);
            List<CustomerDTO> customers = new ArrayList<>();
            for (Customer customer : search) {
                customers.add(new CustomerDTO(customer.getCustomerId(),customer.getName(),customer.getContact()));
            }
            return customers;

    }
}
