package lab2.lab2.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
}
