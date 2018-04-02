package com.cdc.mitrais.jpa_criteria_api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdc.mitrais.jpa_criteria_api.entity.Employee;

public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entitymanager = emFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<Employee> from = criteriaQuery.from(Employee.class);
        
        logger.info("Select All Records...");
        CriteriaQuery<Object> select = criteriaQuery.select(from);
        TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
        List<Object> resultList = typedQuery.getResultList();
        
        logger.info("-----Employee Data-------");
        
        for(Object emp : resultList) {
        	Employee employee = (Employee) emp;
        	logger.info("Employee Id:"+employee.getEid());
        	logger.info("Employee Name:"+employee.getEname());
        	logger.info("Employee Salary:"+employee.getSalary());
        	logger.info("------------------------------------------");
        }
        
        logger.info("---------Select all records by follow ordering------------");
        CriteriaQuery<Object> select1 = criteriaQuery.select(from);
        select1.orderBy(criteriaBuilder.asc(from.get("ename")));
        TypedQuery<Object> typedQuery1 = entitymanager.createQuery(select1);
        List<Object> resultList1 = typedQuery1.getResultList();
        
        for(Object o : resultList1) {
        	Employee emp = (Employee)o;
        	logger.info("EID: "+emp.getEid()+" Ename: "+emp.getEname());
        }
        
        entitymanager.close();
        emFactory.close();
    }
}
