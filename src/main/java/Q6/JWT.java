package Q6;

public class JWT {

f (header == null || !header.startsWith("Bearer ")) {
    chain.doFilter(req, res);
    return;
}
String token = header.substring(6);   // extract token
String username = jwtUtil.extractUsername(token);
if (username != null) {
    UsernamePasswordAuthenticationToken auth =
        new UsernamePasswordAuthenticationToken(username, null, null);
    SecurityContextHolder.getContext().setAuthentication(auth);
}
chain.doFilter(req, res);
}