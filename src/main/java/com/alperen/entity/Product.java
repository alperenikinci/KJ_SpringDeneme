package com.alperen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Size(min = 10,max = 15)
//    @NotBlank
    @Column(nullable = false)
    private String productName;
    @Email
    private String productCategory;
//    @Size(min = 0)
    private Double productPrice;
    @Column(nullable = false)
    private Integer productUnitInStock;
    private String productDescription;
}
