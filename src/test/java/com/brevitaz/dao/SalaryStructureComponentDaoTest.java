package com.brevitaz.dao;

import com.brevitaz.model.SalaryStructureComponent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalaryStructureComponentDaoTest
{
  /*  @Autowired
    SalaryStructureComponentDao salaryStructureComponentDao;

    @Test
    public void createTest() throws IOException {
        SalaryStructureComponent salaryStructureComponent= new SalaryStructureComponent();

        salaryStructureComponent.setId("1");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);

        boolean status = salaryStructureComponentDao.create(salaryStructureComponent);
        Assert.assertEquals(true,status);
    }

    @Test
    public void getAllTest() throws IOException {
        SalaryStructureComponent salaryStructureComponent= new SalaryStructureComponent();

        salaryStructureComponent.setId("2");
        salaryStructureComponent.setDisplayName("HRA");
        salaryStructureComponent.setName("HRA@10%");
        salaryStructureComponent.setValue(10);

        boolean status = salaryStructureComponentDao.create(salaryStructureComponent);
        Assert.assertEquals(true,status);

        List<SalaryStructureComponent> salaryStructureComponents = salaryStructureComponentDao.getAll();
        int size = salaryStructureComponents.size();
        System.out.println("SIZE IS:"+size);
        Assert.assertEquals(2,size);

    }

    @Test
    public void updateTest() throws IOException {
        SalaryStructureComponent salaryStructureComponent= new SalaryStructureComponent();

        salaryStructureComponent.setId("3");
        salaryStructureComponent.setDisplayName("CE");
        salaryStructureComponent.setName("CE@2000F");
        salaryStructureComponent.setValue(2000);

        boolean status = salaryStructureComponentDao.create(salaryStructureComponent);
        Assert.assertEquals(true,status);

        salaryStructureComponent.setName("CE@2000");
        boolean status1 = salaryStructureComponentDao.update(salaryStructureComponent,"3");
        Assert.assertEquals(true,status1);
    }

    @Test
    public void deleteTest() throws IOException {
        SalaryStructureComponent salaryStructureComponent= new SalaryStructureComponent();

        salaryStructureComponent.setId("4");
        salaryStructureComponent.setDisplayName("djsn");
        salaryStructureComponent.setName("djkdm");
        salaryStructureComponent.setValue(10);

        boolean status = salaryStructureComponentDao.create(salaryStructureComponent);
        Assert.assertEquals(true,status);

        boolean status1 = salaryStructureComponentDao.delete("4");
        Assert.assertEquals(true,status1);
    }

    @Test
    public void getByIdTest() throws IOException {
        SalaryStructureComponent salaryStructureComponent= new SalaryStructureComponent();

        salaryStructureComponent.setId("4");
        salaryStructureComponent.setDisplayName("HRAS");
        salaryStructureComponent.setName("HRAS@5000");
        salaryStructureComponent.setValue(5000);

        boolean status = salaryStructureComponentDao.create(salaryStructureComponent);
        Assert.assertEquals(true,status);

        SalaryStructureComponent salaryStructureComponent1 = salaryStructureComponentDao.getById("4");
        Assert.assertNotNull(salaryStructureComponent1);
    }
*/
}
