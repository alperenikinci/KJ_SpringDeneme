package com.alperen.dto.converter;

import com.alperen.dto.request.ProductCreateRequestDto;
import com.alperen.dto.response.ProductResponseDto;
import com.alperen.entity.Product;

public class ProductConverter {


    public static ProductResponseDto fromProductToResponseDto(Product product) {
        return  ProductResponseDto.builder()
                .productDescriptio(product.getProductDescription())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .build();
    }

    public static Product fromProductCreateRequestToProduct(ProductCreateRequestDto dto){
        return Product.builder()
                .productDescription(dto.getProductDescriptio())
                .productCategory(dto.getProductCategory())
                .productPrice(dto.getProductPrice())
                .productName(dto.getProductName())
                .productUnitInStock(dto.getProductUnitInStock())
                .build();
    }
}
