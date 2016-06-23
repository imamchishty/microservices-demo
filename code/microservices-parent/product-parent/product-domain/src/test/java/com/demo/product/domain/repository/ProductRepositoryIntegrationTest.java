package com.demo.product.domain.repository;

import com.demo.product.domain.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * <pre>
 *     Database schema is generated by fly-way.
 *     'data.sql' sets up the necessary test data
 * </pre>
 * @author imamchishty
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ProductRepositoryIntegrationTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void should_find_by_manufacturer() {
        assertEquals(1, repository.findByManufacturer("BMW").size());
    }

}
