import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainClass {
    public static void main(String[] args) throws Exception{
        
        //get a runtime to exec the process in a different thread.
        Runtime r = Runtime.getRuntime();
        
        //for windows call 'cmd' instead of 'sh' with different set of args.
        String[] nargs = { "sh", "-c" ,"ls -l" };
        
        //exec the process with 'nargs' as arguments.
        Process p = r.exec(nargs);
        
        //A buffered reader for the process. Buffered is recommended.
        BufferedReader is = new BufferedReader(new InputStreamReader(p.getInputStream()));
        
        //display all the lines.
        String line;
        while ((line = is.readLine()) != null)
            System.out.println(line);
    }
    
}


/*
 Output:
 
 total 16
 -rw-r--r--  1 user  staff  1054 Jun 15 13:11 MainClass.class
 -rw-r--r--@ 1 user  staff   993 Jun 15 13:11 MainClass.java
 
 */