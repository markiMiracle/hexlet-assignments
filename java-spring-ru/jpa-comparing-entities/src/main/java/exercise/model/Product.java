package exercise.model;

import jakarta.persistence.EntityResult;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"title", "price"})
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    private Integer price;
}
