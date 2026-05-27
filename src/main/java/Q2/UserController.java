package Q2;

@Controller
@RequestMapping("/api/users")
public class UserController {
    @Autowired UserService service;
}
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User u = service.findById(id);
        return new ResponseEntity<>(u, HttpStatus.OK);
    