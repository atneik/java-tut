public class MainClass {
    public static void main(String args[]) {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        
        //command for shell code execution 
        String cmd[] = {"sh","-c","for ((i = 0; i <= 10000; i++)); do echo $i; done"};
        try {
        
        //exec subprocess with no waitFor
            p = r.exec(cmd);
        } catch (Exception e) {
            System.out.println("error executing " + cmd[0]);
        }
        System.out.println("did not wait for subprocess");
        
        
        try {
        //exec subprocess with waitFor
            p = r.exec(cmd);
            System.out.println("waiting..");
            p.waitFor();
        } catch (Exception e) {
            System.out.println("error executing " + cmd[0]);
        }
        System.out.println("waited for subprocess");
    }
}

/*
 output:
 
 did not wait for subprocess
 waiting..
 waited for subprocess
 
*/