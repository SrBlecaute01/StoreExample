package br.com.blecaute.store.service;

import br.com.blecaute.store.dto.address.AddressCreateDTO;
import br.com.blecaute.store.dto.address.AddressDTO;
import br.com.blecaute.store.dto.address.AddressUpdateDTO;
import br.com.blecaute.store.exception.address.AddressNotFoundException;
import br.com.blecaute.store.exception.user.UserNotFoundException;
import br.com.blecaute.store.model.Address;
import br.com.blecaute.store.repository.AddressRepository;
import br.com.blecaute.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;
    private UserRepository userRepository;

    private ModelMapper mapper;

    public AddressDTO findById(long id) {
        return mapper.map(
                addressRepository.findById(id).orElseThrow(AddressNotFoundException::new),
                AddressDTO.class
        );
    }

    public AddressDTO save(long userId, AddressCreateDTO dto) {
        final var user =  userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        final var address = addressRepository.save(Address.builder()
                .code(dto.getCode())
                .street(dto.getStreet())
                .complement(dto.getComplement())
                .number(dto.getNumber())
                .user(user)
                .build());

        return mapper.map(address, AddressDTO.class);
    }

    public void delete(long id) {
        if (!addressRepository.existsById(id)) {
            throw new AddressNotFoundException();
        }

        addressRepository.deleteById(id);
    }

    public AddressDTO update(long id, AddressUpdateDTO dto) {
        final var address = addressRepository.findById(id).orElseThrow(AddressNotFoundException::new);
        final var number = dto.getNumber();
        final var code = dto.getCode();
        final var complement = dto.getComplement();

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
