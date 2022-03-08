package br.com.blecaute.store.service;

import br.com.blecaute.store.dto.UserCreateDTO;
import br.com.blecaute.store.dto.UserDTO;
import br.com.blecaute.store.dto.UserUpdateDTO;
import br.com.blecaute.store.exception.EmailAlreadyRegisteredException;
import br.com.blecaute.store.exception.UserNotFoundException;
import br.com.blecaute.store.model.User;
import br.com.blecaute.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private ModelMapper mapper;

    public List<UserDTO> findAll() {
        return mapper.map(repository.findAll(), new TypeToken<List<UserDTO>>() {}.getType());
    }

    public UserDTO findById(long id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("The user with provided id was not found");
        }

        return mapper.map(user.get(), UserDTO.class);
    }

    public UserDTO findByEmail(String email) {
        Optional<User> user = repository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UserNotFoundException("The user with provided email was not found");
        }

        return mapper.map(user.get(), UserDTO.class);
    }

    public UserDTO save(UserCreateDTO userDto) {
        if (repository.existsByEmail(userDto.getEmail())) {
            throw new EmailAlreadyRegisteredException("The email provided was already registered");
        }

        User user = repository.save(User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .createdAt(new Date())
                .build());

        return mapper.map(user, UserDTO.class);
    }

    public void delete(long id) {
        if (!repository.existsById(id)) {
            throw new UserNotFoundException("The user with provided id was not found");
        }

        repository.deleteById(id);
    }

    public UserDTO update(long id, UserUpdateDTO dto) {
        Optional<User> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new UserNotFoundException("The user with provided id was not found");
        }

        String email = dto.getEmail();
        if (dto.getEmail() != null && repository.existsByEmail(email)) {
            throw new EmailAlreadyRegisteredException("The email provided was already registered");
        }

        User user = repository.save(optional.map(input -> {
            input.setEmail(dto.getEmail());
            input.setName(dto.getEmail());
            input.setPassword(dto.getPassword());

            return input;

        }).get());

        return mapper.map(user, UserDTO.class);
    }

}
