package Q15;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced   // enables RestTemplate to resolve "service-name" via Eureka
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

// Usage (no hardcoded IP needed):
restTemplate.getForObject("http://order-service/api/orders", Order[].class);