package com.alperen.controller;

import com.alperen.dto.request.ProductCreateRequestDto;
import com.alperen.dto.response.ProductResponseDto;
import com.alperen.entity.Product;
import com.alperen.mapper.ProductMapper;
import com.alperen.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product") //localhost:8080/product
@RequiredArgsConstructor
//@CrossOrigin("*")
public class ProductController {

    /*
     * @RequestBody Parametreleri gövde ({}) içerisinde göndermek için kulllanılır.
     * JSON olarak gönderir, java tarafında derler ve sınıf haline getirir.
     *
     * @RequestParam Parametreleri url içerisinde gönderir.
     * OR: //http://localhost:8080/product/find-by-id?id=1 burada @RequestParam kullanılmış, id parametresi url üzerinden verilmiştir.
     * NOT: bir endpoint metodunun parametresine hiçbir anotasyon yazılmazsa default @RequestParam olur.
     *
     * @PathVariable Tek bir parametreyi url üzerinde ? koyup parametrenin adını bile belirtmeye gerek duymadan. Direkt olarak
     * parametre değerini verip, metodu tetiklemeyi sağlıyor.
     * OR: http://localhost:8080/product/find-by-id2/1 -> ?id=1 yerine direkt olarak /1 kullanabiliyoruz.
     * */

    private final ProductService productService;

    /*
    http://localhost:8080/product/save?
    productName=SampleProduct&
    productCategory=SampleCategory&
    productPrice=19.99&
    productUnitInStock=100&
    productDescription=SampleDescription
     */
//    @Value("${table-constraints.column-uniqueness}")
//    String value
//        System.out.println(value);
    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/create")
    public ProductResponseDto save1(@RequestBody @Valid ProductCreateRequestDto dto) {
        return productService.saveProduct(dto);
    }
    @PostMapping("/create2")
    public ResponseEntity<ProductResponseDto> save2(@RequestBody @Valid ProductCreateRequestDto dto) {
            return ResponseEntity.ok(productService.saveProduct2(dto));
    }
    @PostMapping("/create3")
    public ResponseEntity<ProductResponseDto> save3(@RequestBody @Valid ProductCreateRequestDto dto) {
        return ResponseEntity.ok(productService.saveProduct3(dto));
    }

    @GetMapping("/find-all") //http://localhost:8080/product/find-all
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/find-by-id") //http://localhost:8080/product/find-by-id?id=1
    public Optional<Product> findById(@RequestParam("id") Integer id) {
        return productService.findById(id);
    }

    @GetMapping("/find-by-id2/{id}") //http://localhost:8080/product/find-by-id?id=1
    public Optional<ProductResponseDto> findById2(@PathVariable Integer id) {
        return productService.findById2(id);
    }

    @GetMapping("find-all-by-price-less-than")
    public List<ProductResponseDto> findByPriceLessThan(Double price){
        return productService.findByPriceLessThan(price);
    }
    @GetMapping("find-all-by-price-less-than-mapper")
    public List<ProductResponseDto> findByPriceLessThanMapper(Double price){
        return productService.findByPriceLessThanMapper(price);
    }
}
