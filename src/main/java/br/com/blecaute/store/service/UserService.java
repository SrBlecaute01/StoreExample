package br.com.blecaute.store.service;

import br.com.blecaute.store.dto.user.UserCreateDTO;
import br.com.blecaute.store.dto.user.UserDTO;
import br.com.blecaute.store.dto.user.UserUpdateDTO;
import br.com.blecaute.store.exception.email.EmailAlreadyRegisteredException;
import br.com.blecaute.store.exception.user.UserNotFoundException;
import br.com.blecaute.store.model.User;
import br.com.blecaute.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private ModelMapper mapper;

    public List<UserDTO> findAll() {
        return mapper.map(repository.findAll(), new TypeToken<List<UserDTO>>() {}.getType());
    }

    public UserDTO findById(long id) {
        return mapper.map(
                repository.findById(id).orElseThrow(UserNotFoundException::new),
                UserDTO.class
        );
    }

    public UserDTO findByEmail(String email) {
        return mapper.map(
                repository.findByEmail(email).orElseThrow(UserNotFoundException::new),
                UserDTO.class
        );
    }

    public UserDTO save(UserCreateDTO userDto) {
        if (repository.existsByEmail(userDto.getEmail())) {
            throw new EmailAlreadyRegisteredException();
        }

        final var user = repository.save(User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .createdAt(new Date())
                .build());

        UserDTO dto = mapper.map(user, UserDTO.class);
        dto.setAddress(Collections.emptySet());

        return dto;
    }

    public void delete(long id) {
        if (!repository.existsById(id)) {
            throw new UserNotFoundException();
        }

        repository.deleteById(id);
    }

    public UserDTO update(long id, UserUpdateDTO dto) {
        final var user = repository.findById(id).orElseThrow(UserNotFoundException::new);
        final var email = dto.getEmail();

        if (user.getEmail().equals(email) && repository.existsByEmail(email)) {
            throw new EmailAlreadyRegisteredException();
        }

        final var password = dto.getPassword();
        final var name = dto.getName();

        if (name != null) {
            user.setName(name);
        }

        if (email != null) {
            user.setEmail(email);
        }

        if (password != null) {
            user.setPassword(password);
        }

        return mapper.map(repository.save(user), UserDTO.class);
    }

}
