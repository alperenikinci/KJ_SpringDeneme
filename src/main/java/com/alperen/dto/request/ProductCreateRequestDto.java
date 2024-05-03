package com.alperen.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateRequestDto {

//    @Size(min = 10,max = 15)
    @NotBlank
    private String productName;
//    @Email
    private String productCategory;
    private Double productPrice;
    private Integer productUnitInStock;
    private String productDescriptio;
}
