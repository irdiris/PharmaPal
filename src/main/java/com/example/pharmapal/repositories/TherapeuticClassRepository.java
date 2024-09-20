package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.DAOs.TopSoldClasses;
import com.example.pharmapal.entities.TherapeuticClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TherapeuticClassRepository extends JpaRepository<TherapeuticClass, Long> {

    boolean existsByName(String name);
    boolean existsByDescription(String description);

    @Query("SELECT tc FROM TherapeuticClass tc LEFT JOIN FETCH tc.productsSet")
    List<TherapeuticClass> findAllWithProducts();


    @Query(
            value = "SELECT " +
                    "   tc.description, " +
                    "   tc.name, " +
                    "   COUNT(ps.products_sold_id) AS totalSales, " +
                    "   COUNT(CASE WHEN t.date_time = CURRENT_DATE THEN ps.products_sold_id END) AS dailySales " +
                    "FROM " +
                    "    pharma_pal.therapeutic_class tc " +
                    "    JOIN pharma_pal.products p ON tc.t_class_id = p.therapeutic_class " +
                    "    JOIN pharma_pal.stocked_products sp ON p.product_id = sp.product_id " +
                    "    JOIN pharma_pal.products_sold ps ON sp.id = ps.stocked_products_id " +
                    "        AND sp.lot_number = ps.stocked_products_lot_number " +
                    "        AND sp.product_id = ps.stocked_products_product_id " +
                    "        AND sp.supplier = ps.stocked_products_supplier " +
                    "    JOIN pharma_pal.transactions t ON ps.transaction_trans_id = t.trans_id " +
                    "GROUP BY " +
                    "    tc.t_class_id, tc.name, tc.description",
            nativeQuery = true
    )
    List<Object[]> getSalesByClass();

}
