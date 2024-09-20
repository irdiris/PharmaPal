package com.example.pharmapal.controller;


import com.example.pharmapal.entities.*;
import com.example.pharmapal.entities.DAOs.DailyTransactionsDAO;
import com.example.pharmapal.entities.DAOs.TopSoldClasses;
import com.example.pharmapal.entities.DAOs.WeeklyTransactionsDAO;
import com.example.pharmapal.entities.DTOs.ProductsDTO;
import com.example.pharmapal.entities.DTOs.StockedProductsDTO;
import com.example.pharmapal.entities.DTOs.SupplierDTO;
import com.example.pharmapal.interfaces.*;
import com.example.pharmapal.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

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
    private final StaffServiceInterface staffService;

    private final TransactionsServiceInterface transactionsService;
    private final AdministrationTypeServiceInterface administrationTypeService;

    public StaffController(ProductsService productsService, ProductFormServiceInterface productFormService, TherapeuticClassService therapeuticClassService, StockedProductService stockedProductService, SuppliersService supplierService, BillsService billsService, LendsService lendsService, StaffService staffService, TransactionsService transactionsService, AdministrationTypeService administrationTypeService) {
        this.productsService = productsService;
        this.productFormService = productFormService;
        this.therapeuticClassService = therapeuticClassService;
        this.stockedProductService = stockedProductService;
        this.supplierService = supplierService;
        this.billsService = billsService;
        this.lendsService = lendsService;
        this.staffService = staffService;
        this.transactionsService = transactionsService;
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
        return new  ResponseEntity<>(response, HttpStatus.CREATED);
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
        return new  ResponseEntity<>(response, HttpStatus.CREATED);
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
    @GetMapping("/getSalesByClass")
    public ResponseEntity<List<TopSoldClasses>> getSalesByClass(){
        List<TopSoldClasses> salesByClass;
        salesByClass = therapeuticClassService.getSalesByClass();
        return new  ResponseEntity<>(salesByClass, HttpStatus.OK);
    }

    @PostMapping("/addTherapeuticClass")
    public ResponseEntity<String> addTherapeuticClass (@RequestBody TherapeuticClass therapeuticClass){
           System.out.println(therapeuticClass);
         String response = therapeuticClassService.addTClass(therapeuticClass);
        return new  ResponseEntity<>(response, HttpStatus.CREATED);
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
    @GetMapping("/getAvailableProducts")
    public ResponseEntity<List<StockedProducts>> getAvailableProducts(){
        List<StockedProducts> stockedProducts;
        stockedProducts = stockedProductService.getAvailableProducts();
        return new  ResponseEntity<>(stockedProducts, HttpStatus.OK);
    }
    @PostMapping("/addStockedProduct")
    public ResponseEntity<String> addStockedProduct (@RequestBody StockedProducts stockedProducts){
        String response = stockedProductService.stockProducts(stockedProducts);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateStockedProduct (@RequestBody StockedProductsDTO updatedStockedProducts){
        String response = stockedProductService.updateStockedProduct(updatedStockedProducts);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/getCloseExpirationProducts")
    public ResponseEntity<Integer> getCloseExpirationProducts(){
        int closeExpirationProducts = stockedProductService.getCloseExpirationProducts();
        return new  ResponseEntity<>(closeExpirationProducts, HttpStatus.OK);
    }
    @GetMapping("/getNearExpirationProducts")
    public ResponseEntity<Integer> getNEarExpirationProducts(){
        int nearExpirationProducts = stockedProductService.getNearExpirationProducts();
        return new  ResponseEntity<>(nearExpirationProducts, HttpStatus.OK);
    }


    @GetMapping("/getBills")
    public ResponseEntity<List<Bills>> getBills(){
        List<Bills> bills;
        bills = billsService.getBills();
        return new  ResponseEntity<>(bills, HttpStatus.OK);
    }
    @PostMapping("/addBill")
    public ResponseEntity<String> addBills (@RequestBody Bills bill){
        System.out.println(bill);
          String response = billsService.addBills(bill);
          return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/getSuppliers")
    public ResponseEntity<List<Suppliers>> getSuppliers(){
        List<Suppliers> suppliers;
        suppliers = supplierService.getSuppliers();
        return new  ResponseEntity<>(suppliers, HttpStatus.OK);
    }
    @PostMapping("/addSupplier")
    public ResponseEntity<String> addSupplier (@RequestBody Suppliers suppliers){
        System.out.println(suppliers);
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
    @PostMapping("/addLend")
    public ResponseEntity<String> addLend (@RequestBody Lends lend){

        String response = lendsService.addLend(lend);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/getTodayRevenue")
    public ResponseEntity<Double> getTodayRevenue(){
       Double todayRevenue = transactionsService.getTodayRevenue();
       return new  ResponseEntity<>(todayRevenue, HttpStatus.OK);

    }
    @GetMapping("/getYesterdayRevenue")
    public ResponseEntity<Double> getYesterdayRevenue(){
        Double todayRevenue = transactionsService.getYesterdayRevenue();
        return new  ResponseEntity<>(todayRevenue, HttpStatus.OK);

    }
    @PostMapping("/registerTransaction")
    public ResponseEntity<Map<String, String>> registerTransaction (@RequestBody Transactions transactions){

        String response = transactionsService.registerTransaction(transactions);
        return new ResponseEntity<>(Collections.singletonMap("message" , response), HttpStatus.CREATED);
    }
    @GetMapping("/getTransactions")
    public ResponseEntity<List<Transactions>> getTransactions (){

        List<Transactions> transactions = transactionsService.getTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @GetMapping("/getDueTotal")
    public ResponseEntity<Double> getDueTotal (){

        Double total = billsService.getDueTotal();
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
    @GetMapping("/getWeeklyTransactionSummary")
    public ResponseEntity<HashMap<Integer, List<WeeklyTransactionsDAO>>> getWeeklyTransactionSummary (){

        List<WeeklyTransactionsDAO> thisWeeksTransactions = transactionsService.getWeeklyTransactionSummary(LocalDate.now());
        List<WeeklyTransactionsDAO> lastWeeksTransactions = transactionsService.getWeeklyTransactionSummary(LocalDate.now().minusDays(5));
        HashMap<Integer, List<WeeklyTransactionsDAO>> transactionsHashMap = new HashMap<>();
        transactionsHashMap.put(1,lastWeeksTransactions );
        transactionsHashMap.put(2,thisWeeksTransactions );
       return new ResponseEntity<>(transactionsHashMap, HttpStatus.OK);
    }
    @GetMapping("/getTodayTransactions")
    public ResponseEntity<DailyTransactionsDAO> getTodayTransactions (){

        DailyTransactionsDAO dailyTransactionsDAO = transactionsService.getTodayTransactions();
        return new ResponseEntity<>(dailyTransactionsDAO, HttpStatus.OK);
    }

}
