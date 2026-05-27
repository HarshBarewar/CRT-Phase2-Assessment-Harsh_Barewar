package Q13;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    public PaymentResponse processPayment(PaymentRequest request) {
        return restTemplate.postForObject(
            "http://payment-service/api/pay",
            request,
            PaymentResponse.class
        );
    }

    public PaymentResponse paymentFallback(PaymentRequest request, Exception e) {
        PaymentResponse fallback = new PaymentResponse();
        fallback.setStatus("FAILED");
        fallback.setMessage("Payment service is unavailable. Try again later.");
        return fallback;
    }
}