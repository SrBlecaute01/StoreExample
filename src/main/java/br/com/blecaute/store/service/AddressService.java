package br.com.blecaute.store.service;

import br.com.blecaute.store.dto.address.AddressCreateDTO;
import br.com.blecaute.store.dto.address.AddressDTO;
import br.com.blecaute.store.dto.address.AddressUpdateDTO;
import br.com.blecaute.store.exception.address.AddressNotFoundException;
import br.com.blecaute.store.exception.user.UserNotFoundException;
import br.com.blecaute.store.model.Address;
import br.com.blecaute.store.model.User;
import br.com.blecaute.store.repository.AddressRepository;
import br.com.blecaute.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;
    private UserRepository userRepository;

    private ModelMapper mapper;

    public AddressDTO findById(long id) {
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AddressNotFoundException("The address with provided id was not found");
        }

        return mapper.map(optional.get(), AddressDTO.class);
    }

    public AddressDTO save(long user, AddressCreateDTO dto) {
        Optional<User> optional = userRepository.findById(user);
        if (optional.isEmpty()) {
            throw new UserNotFoundException("The user with provided id was not found");
        }

        Address address = addressRepository.save(Address.builder()
                .code(dto.getCode())
                .street(dto.getStreet())
                .complement(dto.getComplement())
                .number(dto.getNumber())
                .user(optional.get())
                .build());

        return mapper.map(address, AddressDTO.class);
    }

    public void delete(long id) {
        if (!addressRepository.existsById(id)) {
            throw new AddressNotFoundException("The address with provided id was not found");
        }

        addressRepository.deleteById(id);
    }

    public AddressDTO update(long id, AddressUpdateDTO dto) {
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AddressNotFoundException("The address with provided id was not found");
        }

        Address address = optional.get();

        Long number = dto.getNumber();
        String code = dto.getCode();
        String complement = dto.getComplement();

        if (number != null) {
            address.setNumber(number);
        }

        if (code != null) {
            address.setCode(code);
        }

        if (complement != null) {
            address.setComplement(complement);
        }

        return mapper.map(addressRepository.save(address), AddressDTO.class);
    }

}
