package Q7;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.price < :maxPrice AND p.category = :category")
    List<Product> findByPriceAndCategory(
        @Param("maxPrice") double maxPrice,
        @Param("category") String category
    );
}