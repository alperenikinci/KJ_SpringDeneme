package com.alperen.service;

import com.alperen.dto.converter.ProductConverter;
import com.alperen.dto.request.ProductCreateRequestDto;
import com.alperen.dto.response.ProductResponseDto;
import com.alperen.entity.Product;
import com.alperen.exception.ErrorType;
import com.alperen.exception.ProductManagerException;
import com.alperen.mapper.ProductMapper;
import com.alperen.repository.ProductRepository;
import com.alperen.utility.ServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements ServiceCrud<Product, Integer> {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }


    public ProductResponseDto saveProduct(ProductCreateRequestDto dto) {
        Product product = Product.builder()
                .productDescription(dto.getProductDescriptio())
                .productCategory(dto.getProductCategory())
                .productPrice(dto.getProductPrice())
                .productName(dto.getProductName())
                .productUnitInStock(dto.getProductUnitInStock())
                .build();
        productRepository.save(product);
        ProductResponseDto responseDto = ProductResponseDto.builder()
                .productDescriptio(product.getProductDescription())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .build();
        return responseDto;
    }

    public ProductResponseDto saveProduct2(ProductCreateRequestDto dto) {
//        Product product = ProductConverter.fromProductCreateRequestToProduct(dto);
//        productRepository.save(product);
//        ProductResponseDto responseDto = ProductConverter.fromProductToResponseDto(product);
//        return responseDto;
        try {
            Product product = productRepository.save(ProductConverter.fromProductCreateRequestToProduct(dto));
            return ProductConverter.fromProductToResponseDto(product);
        } catch (Exception e){
            throw new RuntimeException("Non response entity exception.");
        }

    }

    public ProductResponseDto saveProduct3(ProductCreateRequestDto dto) {
        try {
            Product product = productRepository.save(ProductMapper.INSTANCE.fromProductCreateRequestToProduct(dto));
            return ProductMapper.INSTANCE.fromProductToProductResponseDto(product);
        } catch (Exception e){
            throw new ProductManagerException(ErrorType.BAD_REQUEST,"Response entity exception");
        }
    }

    public List<ProductResponseDto> findByPriceLessThan(Double price) {
        List<Product> productList = productRepository.findAllByProductPriceLessThan(price);
        List<ProductResponseDto> productResponseDtoList = productList
                .stream().map(x -> ProductMapper
                        .INSTANCE.fromProductToProductResponseDto(x)).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Optional<ProductResponseDto> findById2(Integer id) {
        return Optional.ofNullable(ProductConverter.fromProductToResponseDto(productRepository.findById(id).get()));
    }

    public List<ProductResponseDto> findByPriceLessThanMapper(Double price) {

        return ProductMapper.INSTANCE.fromProductListToResponseList(productRepository.findAllByProductPriceLessThan(price));
    }
}
