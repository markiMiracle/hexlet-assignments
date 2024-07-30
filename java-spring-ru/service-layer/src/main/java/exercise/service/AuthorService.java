package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorMapper mapper;

    @Autowired
    private AuthorRepository repository;

    public List<AuthorDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::map)
                .toList();
    }

    public AuthorDTO findById(Long id) {
        return mapper.map(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found")));
    }

    public AuthorDTO create(AuthorCreateDTO dto) {
        var author = mapper.map(dto);
        repository.save(author);
        return mapper.map(author);
    }

    public AuthorDTO update(AuthorUpdateDTO data, Long id) {
        var author = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        mapper.update(data, author);
        repository.save(author);
        return mapper.map(author);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
