package br.com.blecaute.store.service;

import br.com.blecaute.store.dto.UserDTO;
import br.com.blecaute.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private ModelMapper mapper;

    public List<UserDTO> findAll() {
        return mapper.map(repository.findAll(), new TypeToken<List<UserDTO>>() {}.getType());
    }



}
