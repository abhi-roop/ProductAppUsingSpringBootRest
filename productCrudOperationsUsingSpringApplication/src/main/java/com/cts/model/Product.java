package com.cts.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "products_info")
@Data
@RequiredArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int productId;
  
//	@NotNull
//	@NotEmpty // it allow space " " not allow "" empty
    @NotBlank(message = "Product name can't be blank")
    private String productName;

    @Min(value = 0, message = "Price should not be less than 0")
    @Max(value = 100000,message = "ProductPrice must be below 1 lac")
    @Column(name = "price")
    private int productPrice;
	@Size(min=5,max=12,message = "Category lenght must be between(5,12) ")
    @NotBlank(message = "Product category can't be blank")
    private String productCategory;

	@Positive(message="Quantity must be postive")
    @Column(name = "quantity")
    private int productQuantity;

    public Product(String productName, int productPrice, String productCategory, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
    }
}
