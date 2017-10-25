/**
 * Created by viamator on 19/10/2017.
 */
import java.util.Scanner;
class ex211 {
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
}
