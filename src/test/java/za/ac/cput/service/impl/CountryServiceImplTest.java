//Name: Levi Williams
// Student Number: 218250142
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.service.service.CountryService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryServiceImplTest {
    private final Country country= CountryFactory
            .build("test-Id", "South Africa");
    private Country.CountryIdentity countryIdentity=CountryFactory.buildId(this.country);
    @Autowired
    private CountryService service;

    @Test
    @Order(1)
    void save()
    {
        Country saved=this.service.save(this.country);
        assertAll(
                ()->assertNotNull(saved),
                ()->assertEquals(this.country,saved)
        );
    }
    @Test
    @Order(4)
    void tearDown(){this.service.delete(this.country);}

    @Test
    @Order(2)
    void read()
    {
        Optional<Country> read=this.service.read(this.countryIdentity);
        System.out.println(read);
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertEquals(this.country,read.get())
        );
    }
    @Test
    @Order(5)
    void findAll()
    {
        List<Country> countryList=this.service.findAll();
        assertEquals(0,countryList.size());
    }
    @Test
    @Order(3)
    void findByCountryId()
    {
        String countryId=this.countryIdentity.getCountryId();
        List<Country>countryList=this.service.findByCountryId(countryId);
        System.out.println(countryList);
        assertSame(1,countryList.size());
    }
}
