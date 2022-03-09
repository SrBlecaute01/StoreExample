package br.com.blecaute.store;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreConfiguration {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

}
