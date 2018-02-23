package com.brevitaz.dao;


import com.brevitaz.model.Salary;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalaryDaoTest
{
    @Autowired
    SalaryDao salaryDao;

    @Test
    public void createTest() throws IOException {
        Salary salary = new Salary();
        salary.setId("1");
        salary.setEid("1");
        salary.setSsId("1");
        salary.setGrossSalary(1200000);
        salary.setVariablePay(60000);
        salary.setOtherAllowance(20000);

        boolean status = salaryDao.create(salary);
        Assert.assertEquals(true,status);
    }

    @Test
    public void getAllTest() throws IOException {
        Salary salary = new Salary();
        salary.setId("2");
        salary.setEid("2");
        salary.setSsId("2");
        salary.setGrossSalary(120000);
        salary.setVariablePay(6000);
        salary.setOtherAllowance(2000);

        boolean status = salaryDao.create(salary);
        Assert.assertEquals(true,status);

        List<Salary> salaries = salaryDao.getAll();
        int size = salaries.size();
        Assert.assertEquals(2,size);
    }

    @Test
    public void updateTest() throws IOException {
        Salary salary = new Salary();
        salary.setId("3");
        salary.setEid("3");
        salary.setSsId("3");
        salary.setGrossSalary(600000);
        salary.setVariablePay(30000);
        salary.setOtherAllowance(100000);

        boolean status = salaryDao.create(salary);
        Assert.assertEquals(true,status);

        salary.setOtherAllowance(10000);
        boolean status1 = salaryDao.update(salary,"3");
        Assert.assertEquals(true,status1);
    }

    @Test
    public void deleteTest() throws IOException {
        Salary salary = new Salary();
        salary.setId("4");
        salary.setEid("4");
        salary.setSsId("4");
        salary.setGrossSalary(1200000);
        salary.setVariablePay(60000);
        salary.setOtherAllowance(20000);

        boolean status = salaryDao.create(salary);
        Assert.assertEquals(true,status);

        boolean status1 = salaryDao.delete("4");
        Assert.assertEquals(true,status1);
    }

    @Test
    public void getByIdTest() throws IOException {
        Salary salary = new Salary();
        salary.setId("5");
        salary.setEid("5");
        salary.setSsId("5");
        salary.setGrossSalary(300000);
        salary.setVariablePay(20000);
        salary.setOtherAllowance(3000);

        boolean status = salaryDao.create(salary);
        Assert.assertEquals(true,status);

        Salary salary1 = salaryDao.getById("5");
        Assert.assertNotNull(salary1);
    }

}
