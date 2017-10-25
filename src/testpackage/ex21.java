package testpackage;
/**
 * Created by vitto on 19/10/2017.
 ^                 # start-of-string
 (?=.*[0-9])       # a digit must occur at least once
  (?=.*[A-Z])       # an upper case letter must occur at least once
 (?=.*[@#_-])  # a special character must occur at least once
 (?=\S+$)          # no whitespace allowed in the entire string
 .{4,32}            # password length must be from 4 to 32 symbols
 */

import java.util.*;
public class ex21 {
        public static void main(String[] args) {
            final int numOfPasswords=4;
            Scanner scan = new Scanner(System.in);
            String[] passwordCandidates=new String[numOfPasswords];
            String pattern = "(?=.*[A-Z])(?=.*[0-9])(?=.*[@#_-])(?=\\S+$).{4,32}";
            for (int i=0;i<numOfPasswords;i++){
                passwordCandidates[i]=scan.nextLine().trim();
            }

            for (int i=0;i<numOfPasswords;i++){
                System.out.println(passwordCandidates[i].matches(pattern)?"PASS":"FAIL");
            }

        }
        public static class PasswordValidator {
            static final String pattern = "(?=.*[A-Z])(?=.*[0-9])(?=.*[@#_-])(?=\\S+$).{4,32}";
            public boolean checkPassword(String passwordCandidate) {
                return passwordCandidate.matches(pattern);
            }
            public synchronized String checkPasswordSynchronized (String passwordCandidate) {
                return passwordCandidate.matches(pattern)?"PASS":"FAIL";
            }
        }
        public static class MyThread extends Thread
        {
            private int numiter;
            private PasswordValidator pv;

            public MyThread(int n){
                this.numiter = n;
                pv=new PasswordValidator();
            }


            @Override
            public void run()
            {
                for(int i = 0; i < numiter; i +=1 )
                {
                    pv.checkPassword("_A1");
                    pv.checkPassword("A1_456789012345678901234567890123");
                    pv.checkPassword("A1_45678901234567890123456789012");
                }
            }
        }
}
