package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper mapper;

    public List<BookDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::map)
                .toList();
    }

    public BookDTO findById(Long id) {
        return mapper.map(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found")));
    }

    public BookDTO create(BookCreateDTO dto) {
        var book = mapper.map(dto);
        repository.save(book);
        return mapper.map(book);
    }

    public BookDTO update(BookUpdateDTO data, Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        mapper.update(data, book);
        repository.save(book);
        return mapper.map(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
