package com.tracker.dao;

import com.tracker.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory; 

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getEmployees() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Employee ORDER BY lastName", Employee.class)
                .list();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> searchEmployees(String searchName) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query;

        if (searchName != null && searchName.trim().length() > 0) {

            query = currentSession.createQuery(
                    "from Employee where " +
                            "lower(firstName) like :name " +
                            "or " +
                            "lower(lastName) like :name",
                    Employee.class);
            query.setParameter("name", searchName.toLowerCase() + "%");

        } else {
            query = currentSession.createQuery("from Employee", Employee.class);
        }

        return query.getResultList();
    }

}


