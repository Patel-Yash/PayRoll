package com.brevitaz.dao;

import com.brevitaz.model.SalaryStructure;
import com.brevitaz.model.SalaryStructureComponent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalaryStructureDaoTest
{
    @Autowired
    SalaryStructureDao salaryStructureDao;

    @Test
    public void createTest() throws IOException {
        SalaryStructureComponent salaryStructureComponent = new SalaryStructureComponent();

        salaryStructureComponent.setId("11");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);

        List<SalaryStructureComponent>salaryStructureComponents = new ArrayList<>();
        salaryStructureComponents.add(salaryStructureComponent);

        SalaryStructure salaryStructure1 = new SalaryStructure();
        salaryStructure1.setId("1");
        salaryStructure1.setSalaryStructureComponents(salaryStructureComponents);

        boolean status = salaryStructureDao.create(salaryStructure1);
        Assert.assertEquals(true,status);
    }

    @Test
    public void getAllTest() throws IOException {
        SalaryStructureComponent salaryStructureComponent = new SalaryStructureComponent();

        salaryStructureComponent.setId("12");
        salaryStructureComponent.setDisplayName("Basics");
        salaryStructureComponent.setName("Basics@19%");
        salaryStructureComponent.setValue(19);

        List<SalaryStructureComponent>salaryStructureComponents = new ArrayList<>();
        salaryStructureComponents.add(salaryStructureComponent);

        SalaryStructure salaryStructure1 = new SalaryStructure();
        salaryStructure1.setId("2");
        salaryStructure1.setSalaryStructureComponents(salaryStructureComponents);

        boolean status = salaryStructureDao.create(salaryStructure1);
        Assert.assertEquals(true,status);

        List<SalaryStructure> salaryStructures = salaryStructureDao.getAll();
        Assert.assertNotNull(salaryStructures);

    }

    @Test
    public void updateTest() throws IOException {
        SalaryStructureComponent salaryStructureComponent = new SalaryStructureComponent();

        salaryStructureComponent.setId("13");
        salaryStructureComponent.setDisplayName("HRA");
        salaryStructureComponent.setName("HRA@10%");
        salaryStructureComponent.setValue(10);

        List<SalaryStructureComponent>salaryStructureComponents = new ArrayList<>();
        salaryStructureComponents.add(salaryStructureComponent);

        SalaryStructure salaryStructure1 = new SalaryStructure();
        salaryStructure1.setId("3");
        salaryStructure1.setSalaryStructureComponents(salaryStructureComponents);

        boolean status = salaryStructureDao.create(salaryStructure1);
        Assert.assertEquals(true,status);
        salaryStructureComponent.setDisplayName("njfmgrk");

        salaryStructure1.setSalaryStructureComponents(salaryStructureComponents);
        boolean status1 = salaryStructureDao.update(salaryStructure1,"3");
        Assert.assertEquals(true,status1);
    }

    @Test
    public void deleteTest() throws IOException {
        SalaryStructureComponent salaryStructureComponent = new SalaryStructureComponent();

        salaryStructureComponent.setId("14");
        salaryStructureComponent.setDisplayName("HRA");
        salaryStructureComponent.setName("HRA@10%");
        salaryStructureComponent.setValue(10);

        List<SalaryStructureComponent>salaryStructureComponents = new ArrayList<>();
        salaryStructureComponents.add(salaryStructureComponent);

        SalaryStructure salaryStructure1 = new SalaryStructure();
        salaryStructure1.setId("4");
        salaryStructure1.setSalaryStructureComponents(salaryStructureComponents);

        boolean status = salaryStructureDao.create(salaryStructure1);
        Assert.assertEquals(true,status);

        boolean status1 = salaryStructureDao.delete("4");
        Assert.assertEquals(true,status1);

    }

    @Test
    public void getByIdTest() throws IOException {
        SalaryStructureComponent salaryStructureComponent = new SalaryStructureComponent();

        salaryStructureComponent.setId("14");
        salaryStructureComponent.setDisplayName("HRA");
        salaryStructureComponent.setName("HRA@20%");
        salaryStructureComponent.setValue(20);

        List<SalaryStructureComponent>salaryStructureComponents = new ArrayList<>();
        salaryStructureComponents.add(salaryStructureComponent);

        SalaryStructure salaryStructure1 = new SalaryStructure();
        salaryStructure1.setId("4");
        salaryStructure1.setSalaryStructureComponents(salaryStructureComponents);

        boolean status = salaryStructureDao.create(salaryStructure1);
        Assert.assertEquals(true,status);

        SalaryStructure salaryStructure = salaryStructureDao.getById("4");
        Assert.assertNotNull(salaryStructure);


    }

}
