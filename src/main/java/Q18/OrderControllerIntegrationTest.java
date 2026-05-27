package Q18;

@SpringBootTest
class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean                       // replaces the real OrderService in the context
    private OrderService orderService;

    @Test
    void getOrder_returns200() throws Exception {
        when(orderService.findById(1L)).thenReturn(new Order(1L, "PLACED"));
        mockMvc.perform(get("/api/orders/1"))
               .andExpect(status().isOk());
    }
}
