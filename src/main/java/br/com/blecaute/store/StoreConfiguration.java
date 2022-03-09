package br.com.blecaute.store;

import br.com.blecaute.store.converter.UserConvert;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreConfiguration {

    @Bean
    public ModelMapper mapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addConverter(new UserConvert());

        return mapper;
    }

}
