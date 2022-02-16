package com.heypli.multimoduleroot.property;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "country")
public class CountryProperty {

    private List<Country> list;

    @Getter
    @Setter
    @ToString
    public static class Country {
        private String name;
        private String capital;
    }

}
