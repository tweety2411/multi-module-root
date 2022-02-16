package com.heypli.multimoduleroot.property;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class PropertyTest {

    @Value("${property.test.name}")
    private String propertyTestName;

    @Value("${propertyList}")
    private List<String> propertyList;

    @Value("#{'${propertyList}'.split(',')}")
    private List<String> proList;

    @Autowired
    CountryProperty property;

    @Test
    public void getPropertyName() {
        assertThat(propertyTestName, is("hiProperty"));
        assertThat(propertyList.size(), is(3));
        assertThat(propertyList.get(0), is("a"));
        assertThat(proList.size(), is(3));
        assertThat(proList.get(1), is("b"));
    }

    @Test
    public void getConfigurationProperty() {
        assertThat(property.getList().size(), is(3));
        assertThat(property.getList().get(0).getName(), is("Korea"));
    }
}
