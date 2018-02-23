package com.brevitaz.dao;

import com.brevitaz.model.Salary;
import com.brevitaz.model.SalarySlip;
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
public class SalarySlipDaoTest
{
    @Autowired
    SalarySlipDao salarySlipDao;

    @Test
    public void createTest() throws IOException {
        SalarySlip salarySlip = new SalarySlip();
        salarySlip.setId("1");
        salarySlip.setEid("1");
        salarySlip.setVariablePay(60000);

        boolean status = salarySlipDao.create(salarySlip);
        Assert.assertEquals(true,status);
    }

    @Test
    public void getAllTest() throws IOException {
        SalarySlip salarySlip = new SalarySlip();
        salarySlip.setId("2");
        salarySlip.setEid("2");
        salarySlip.setVariablePay(30000);

        boolean status = salarySlipDao.create(salarySlip);
        Assert.assertEquals(true,status);

        List<SalarySlip> salarySlips = salarySlipDao.getAll();
        Assert.assertNotNull(salarySlips);
    }

    @Test
    public void updateTest() throws IOException {
        SalarySlip salarySlip = new SalarySlip();
        salarySlip.setId("3");
        salarySlip.setEid("3");
        salarySlip.setVariablePay(60000);

        boolean status = salarySlipDao.create(salarySlip);
        Assert.assertEquals(true,status);

        salarySlip.setVariablePay(30000);
        boolean status1 = salarySlipDao.update(salarySlip,"3");
        Assert.assertEquals(true,status1);
    }

    @Test
    public void deleteTest() throws IOException {
        SalarySlip salarySlip = new SalarySlip();
        salarySlip.setId("4");
        salarySlip.setEid("4");
        salarySlip.setVariablePay(60000);

        boolean status = salarySlipDao.create(salarySlip);
        Assert.assertEquals(true,status);

        boolean status1 = salarySlipDao.delete("4");
        Assert.assertEquals(true,status1);
    }

    @Test
    public void getByIdTest() throws IOException {
        SalarySlip salarySlip = new SalarySlip();
        salarySlip.setId("5");
        salarySlip.setEid("5");
        salarySlip.setVariablePay(6000);

        boolean status = salarySlipDao.create(salarySlip);
        Assert.assertEquals(true,status);

        SalarySlip salarySlip1 = salarySlipDao.getById("5");
        Assert.assertNotNull(salarySlip1);
    }

}
