package br.com.blecaute.store.converter;

import br.com.blecaute.store.dto.address.AddressDTO;
import br.com.blecaute.store.dto.user.UserDTO;
import br.com.blecaute.store.model.Address;
import br.com.blecaute.store.model.User;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class UserConvert implements Converter<User, UserDTO> {

    @Override
    public UserDTO convert(MappingContext<User, UserDTO> context) {

        User source = context.getSource();
        UserDTO destination = context.getDestination();

        System.out.println(source);
        System.out.println(destination);

        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setEmail(source.getEmail());
        destination.setCreatedAt(source.getCreatedAt());

        for (Address address : source.getAddress()) {
            destination.addAddress(new AddressDTO(
                    address.getId(),
                    address.getNumber(),
                    address.getCode(),
                    address.getComplement()));
        }

        return destination;
    }

}
