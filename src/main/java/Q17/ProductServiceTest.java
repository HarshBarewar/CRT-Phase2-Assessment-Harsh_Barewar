package Q17;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repo;

    @InjectMocks
    private ProductService productService;

    @Test
    void getById_shouldReturnProduct_whenFound() {
        // Arrange
        Product sample = new Product();
        sample.setId(1L);
        sample.setName("Laptop");

        when(repo.findById(1L)).thenReturn(Optional.of(sample));

        // Act
        Product result = productService.getById(1L);

        // Assert
        assertEquals("Laptop", result.getName());
        verify(repo, times(1)).findById(1L);
    }
