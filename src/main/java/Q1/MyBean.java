package Q1;

@Component
public class MyBean {
    public MyBean() {
        System.out.println("Constructor called");
    }
    @PostConstruct
    public void init() {
        System.out.println("Init called");
    }
}