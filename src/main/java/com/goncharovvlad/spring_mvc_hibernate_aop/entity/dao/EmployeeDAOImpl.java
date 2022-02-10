package com.goncharovvlad.spring_mvc_hibernate_aop.entity.dao;

import com.goncharovvlad.spring_mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataSource dataSource;




    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();

        List<Employee> allEmployee = session.createQuery("from Employee", Employee.class).getResultList();

        return allEmployee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class,id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id).executeUpdate();

    }

}
