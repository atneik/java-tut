import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MainClass {
    
    static public void main(String[] args) throws Exception
    {
        Process p = Runtime.getRuntime().exec("ls xxxx");
        BufferedReader br = new BufferedReader(new
                                               InputStreamReader(p.getErrorStream()));
        String line;
        while((line = br.readLine()) != null) {
            System.out.println("Read from error stream: \"" + line + "\"");
        }
    }
}


/*
 Output:
 
 Read from error stream: "ls: xxxx: No such file or directory"
 
 */