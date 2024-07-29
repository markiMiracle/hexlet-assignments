package exercise.controller;

import java.util.List;
import java.util.stream.Collectors;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.ProductMapper;
import exercise.model.Product;
import exercise.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.ProductRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping
    public List<ProductDTO> index() {
        return productRepository.findAll().stream()
                .map(entity -> productMapper.map(entity))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDTO show(@PathVariable("id") String id) {
        var product = productRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        var dto = productMapper.map(product);
        dto.setCategoryName(product.getCategory().getName());
        return dto;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductCreateDTO dto) {
        if (categoryRepository.findById(dto.getCategoryId()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Product product = productMapper.map(dto);
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.map(product));
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable("id") String id, @RequestBody ProductUpdateDTO dto) {
        var product = productRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        productMapper.update(dto, product);
        Long categoryId = dto.getCategoryId().get();
        var category = categoryRepository.findById(categoryId).get();
        product.setCategory(category);
        productRepository.save(product);
        return productMapper.map(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        productRepository.deleteById(Long.parseLong(id));
    }
}
