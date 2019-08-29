import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: Bernie
 * @Date: 2019-08-13 11:29
 */
public class Test {
    @org.junit.Test
    public void test(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("admin");
        System.out.println("加密："+encode);
        System.out.println("比较："+passwordEncoder.matches("admin",encode));
    }
}
