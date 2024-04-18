package com.example.pharmapal.Controller;


import com.example.pharmapal.Entities.*;
import com.example.pharmapal.Interfaces.AdministrationTypeServiceInterface;
import com.example.pharmapal.Interfaces.ProductFormServiceInterface;
import com.example.pharmapal.Interfaces.ProductsServiceInterface;
import com.example.pharmapal.Interfaces.TherapeuticClassServiceInterface;
import com.example.pharmapal.Services.ProductsService;
import com.example.pharmapal.Services.StockedProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PharmaPal/Staff")
public class StaffController {
    private final ProductsServiceInterface productsService;
    private final ProductFormServiceInterface productFormService;
    private final TherapeuticClassServiceInterface therapeuticClassService;
    private final StockedProductService stockedProductService;


    private final AdministrationTypeServiceInterface administrationTypeService;

    public StaffController(ProductsService productsService, ProductFormServiceInterface productFormService, TherapeuticClassServiceInterface therapeuticClassService, StockedProductService stockedProductService, AdministrationTypeServiceInterface administrationTypeService) {
        this.productsService = productsService;
        this.productFormService = productFormService;
        this.therapeuticClassService = therapeuticClassService;
        this.stockedProductService = stockedProductService;
        this.administrationTypeService = administrationTypeService;
    }


    @GetMapping("/getProducts")
    public ResponseEntity<List<Products>> getProducts(){
        List<Products> products;
        products = productsService.getProduct();
        return new  ResponseEntity<>(products, HttpStatus.OK);
    }
    public ResponseEntity<String> addProduct (@RequestBody Products products){

        return null;
    }
    public ResponseEntity<String> deleteProduct (@RequestBody Products products){

        return null;
    }
    public ResponseEntity<String> updateProduct (@RequestBody Products products){

        return null;
    }

    @GetMapping("/getProductForms")
    public ResponseEntity<List<ProductForm>> getProductForms(){
        List<ProductForm> productForms;
        productForms = productFormService.getProductFroms();
        return new  ResponseEntity<>(productForms, HttpStatus.OK);
    }
    public ResponseEntity<String> addProductForm (@RequestBody ProductForm productForm){

        return null;
    }
    public ResponseEntity<String> deleteProductForm (@RequestBody ProductForm productForm){

        return null;
    }
    public ResponseEntity<String> updateProductForm (@RequestBody ProductForm productForm){

        return null;
    }

    @GetMapping("/getAdministrationType")
    public ResponseEntity<List<AdministrationType>> getAdministrationType(){
        List<AdministrationType> administrationTypes;
        administrationTypes = administrationTypeService.getAdministrationType();
        return new  ResponseEntity<>(administrationTypes, HttpStatus.OK);
    }
    public ResponseEntity<String> addAdministrationType (@RequestBody AdministrationType administrationType){

        return null;
    }
    public ResponseEntity<String> deleteAdministrationType (@RequestBody AdministrationType administrationType){

        return null;
    }
    public ResponseEntity<String> updateAdministrationType (@RequestBody AdministrationType administrationType){

        return null;
    }
    @GetMapping("/getTherapeuticClass")
    public ResponseEntity<List<TherapeuticClass>> getTherapeuticClass(){
        List<TherapeuticClass> therapeuticClasses;
        therapeuticClasses = therapeuticClassService.getTClasses();
        return new  ResponseEntity<>(therapeuticClasses, HttpStatus.OK);
    }
    public ResponseEntity<String> addTherapeuticClass (@RequestBody TherapeuticClass therapeuticClass){

        return null;
    }
    public ResponseEntity<String> deleteTherapeuticClass (@RequestBody TherapeuticClass therapeuticClass){

        return null;
    }
    public ResponseEntity<String> updateTherapeuticClass (@RequestBody TherapeuticClass therapeuticClass){

        return null;
    }

    @GetMapping("/getStockedProducts")
    public ResponseEntity<List<StockedProducts>> getStockedProducts(){
        List<StockedProducts> stockedProducts;
        stockedProducts = stockedProductService.getStockedProducts();
        return new  ResponseEntity<>(stockedProducts, HttpStatus.OK);
    }
    public ResponseEntity<String> addstockedProduct (@RequestBody StockedProducts stockedProducts){
        return null;
    }
    public ResponseEntity<String> deleteStockedProduct (@RequestBody StockedProducts stockedProducts){

        return null;
    }
    public ResponseEntity<String> updateStockedProduct (@RequestBody StockedProducts stockedProducts){

        return null;
    }

}
