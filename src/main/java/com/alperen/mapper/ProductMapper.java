package com.alperen.mapper;

import com.alperen.dto.request.ProductCreateRequestDto;
import com.alperen.dto.response.ProductResponseDto;
import com.alperen.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "productDescriptio", target = "productDescription")
    Product fromProductCreateRequestToProduct(final ProductCreateRequestDto dto);

    @Mapping(source = "productDescription", target = "productDescriptio")
    ProductResponseDto fromProductToProductResponseDto(final Product product);

    List<ProductResponseDto> fromProductListToResponseList(final List<Product> allByProductPriceLessThan);
}
