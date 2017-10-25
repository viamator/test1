import org.junit.Test;

/**
 * Created by vitto on 19/10/2017.
 * String pattern = "(?=.*[A-Z])(?=.*[0-9])(?=.*[@#_-])(?=\\S+$).{4,32}";
 * There are 5 condition. Our tests should check all this conditions.
 1. The minimum length of the username must be 4 characters, the maximum should be 32.
 2. It should contain at least one letter from A-Z
 3. It should contain at least one digit from 0-9
 4. It should contain at least one special character from amongst @#_-
 5. It should not contain any spaces
 Test 1: password candidate not satisfied 1st condition. the first attempt is too short,
 the second is too long and the third with correct length and also satisfied to all other conditions.
 Test 2: password candidate not satisfied 2st condition.
 Test 3: password candidate not satisfied 2st condition.
 Test 4: password candidate not satisfied 2st condition.
 Test 5: password candidate not satisfied 2st condition.
  */
import testpackage.ex21.*;
public class StringUtilsJUnit4TestTest {
    @Test
    public void passwordValidatorTest() {
        PasswordValidator a1=new PasswordValidator();
        //try all possible combinations of true password conditions
        System.out.println(a1.checkPassword("_A1"));//too short
        System.out.println(a1.checkPassword("A1_456789012345678901234567890123"));//too long
        System.out.println(a1.checkPassword("A1_45678901234567890123456789012"));//correct

        System.out.println(a1.checkPassword("1_abcd"));//without A-Z
        System.out.println(a1.checkPassword("A1_abcd"));//correct
        System.out.println(a1.checkPassword("A1abcd"));//without spec sympol
        System.out.println(a1.checkPassword("A1_abcd"));//correct
        System.out.println(a1.checkPassword("A_abcd"));//without 0-9
        System.out.println(a1.checkPassword("A1_abcd"));//correct
        System.out.println(a1.checkPassword("2wsx#EDC4rfv%TGB"));//correct
    }

    @Test
    public void passwordValidatorPerformanceComparison() {
        long itermax=100000;
        PasswordValidator a1=new PasswordValidator();
        long start = System.currentTimeMillis();
        for (long i=0;i<itermax;i++){
            a1.checkPassword("_A1");
            a1.checkPassword("A1_456789012345678901234567890123");
            a1.checkPassword("A1_45678901234567890123456789012");
        };
        System.out.println(itermax*3*1000/(System.currentTimeMillis()-start)+" password checks in second");
        start = System.currentTimeMillis();
        MyThread[] threads = new MyThread[10];
//        MyThread mt=new MyThread(10000);
        for (int i=0;i<10;i++){
            threads[i]=new MyThread(10000);
            threads[i].run();
        }
        System.out.println(itermax*3*1000/(System.currentTimeMillis()-start)+" password checks in second");
    }

}