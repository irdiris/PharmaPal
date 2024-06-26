package com.example.pharmapal.controller;


import com.example.pharmapal.entities.*;
import com.example.pharmapal.entities.DTOs.ProductsDTO;
import com.example.pharmapal.entities.DTOs.StockedProductsDTO;
import com.example.pharmapal.entities.DTOs.SupplierDTO;
import com.example.pharmapal.interfaces.*;
import com.example.pharmapal.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PharmaPal/Staff")
public class StaffController {
    private final ProductsServiceInterface productsService;
    private final ProductFormServiceInterface productFormService;
    private final TherapeuticClassServiceInterface therapeuticClassService;
    private final StockedProductsServiceInterface stockedProductService;

    private final SupplierServiceInterface supplierService;
    private final BillsServiceInterface billsService;
    private final LendsServiceInterface lendsService;


    private final AdministrationTypeServiceInterface administrationTypeService;

    public StaffController(ProductsService productsService, ProductFormServiceInterface productFormService, TherapeuticClassService therapeuticClassService, StockedProductService stockedProductService, SuppliersService supplierService, BillsService billsService, LendsService lendsService, AdministrationTypeService administrationTypeService) {
        this.productsService = productsService;
        this.productFormService = productFormService;
        this.therapeuticClassService = therapeuticClassService;
        this.stockedProductService = stockedProductService;
        this.supplierService = supplierService;
        this.billsService = billsService;
        this.lendsService = lendsService;
        this.administrationTypeService = administrationTypeService;
    }


    @GetMapping("/getProducts")
    public ResponseEntity<List<Products>> getProducts(){
        List<Products> products;
        products = productsService.getProducts();
        return new  ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct (@RequestBody Products products){
         String response = productsService.addProduct(products);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/updateProduct")
    public ResponseEntity<String> updateProduct (@RequestBody ProductsDTO productsDTO ){
      String response = productsService.updateProducts(productsDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getProductForms")
    public ResponseEntity<List<ProductForm>> getProductForms(){
        List<ProductForm> productForms;
        productForms = productFormService.getProductFroms();
        return new  ResponseEntity<>(productForms, HttpStatus.OK);
    }
    @PostMapping("/addProductForm")
    public ResponseEntity<String> addProductForm (@RequestBody ProductForm productForm){
          String response = productFormService.addProductForm(productForm);
        return new  ResponseEntity<>(response, HttpStatus.OK);
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
    @PostMapping("/addAdministrationType")
    public ResponseEntity<String> addAdministrationType (@RequestBody AdministrationType administrationType){
           String response = administrationTypeService.addAdministrationType(administrationType);
        return new  ResponseEntity<>(response, HttpStatus.OK);
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
    @PostMapping("/addTherapeuticClass")
    public ResponseEntity<String> addTherapeuticClass (@RequestBody TherapeuticClass therapeuticClass){
         String response = therapeuticClassService.addTClass(therapeuticClass);
        return new  ResponseEntity<>(response, HttpStatus.OK);
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
    @PostMapping("/addStockedProduct")
    public ResponseEntity<String> addStockedProduct (@RequestBody StockedProducts stockedProducts){
        String response = stockedProductService.stockProducts(stockedProducts);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> updateStockedProduct (@RequestBody StockedProductsDTO updatedStockedProducts){
        String response = stockedProductService.updateStockedProduct(updatedStockedProducts);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getBills")
    public ResponseEntity<List<Bills>> getBills(){
        List<Bills> bills;
        bills = billsService.getBills();
        return new  ResponseEntity<>(bills, HttpStatus.OK);
    }
    @PostMapping("/addBill")
    public ResponseEntity<String> addBills (@RequestBody Bills bill){
          String response = billsService.addBills(bill);
          return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/getSuppliers")
    public ResponseEntity<List<Suppliers>> getSuppliers(){
        List<Suppliers> suppliers;
        suppliers = supplierService.getSuppliers();
        return new  ResponseEntity<>(suppliers, HttpStatus.OK);
    }
    @PostMapping("/addSupplier")
    public ResponseEntity<String> addSupplier (@RequestBody Suppliers suppliers){
        String response = supplierService.addSupplier(suppliers);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/updateSupplier")
    public ResponseEntity<String> updateSupplier (@RequestBody SupplierDTO supplierDTO){
        String response = supplierService.updateSupplier(supplierDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @GetMapping("/getLends")
    public ResponseEntity<List<Lends>> getLends(){
        List<Lends> lends;
        lends = lendsService.getLends();
        return new  ResponseEntity<>(lends, HttpStatus.OK);
    }
}
