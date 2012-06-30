public class MainClass {
    public static void main(String args[]) {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        
        //command for shell code execution 
        String cmd[] = {"sh","-c","sleep 5"};
        
        long start = System.currentTimeMillis();
        
        try {
        
        //exec subprocess with no waitFor
            p = r.exec(cmd);
        } catch (Exception e) {
            System.out.println("error executing " + cmd[0]);
        }
        long timeElapsed = System.currentTimeMillis() - start;
        System.out.println("Time elasped: " + timeElapsed);
        System.out.println("did not wait for subprocess");
        
        start = System.currentTimeMillis();
        try {
        //exec subprocess with waitFor
            p = r.exec(cmd);
            System.out.println("waiting..");
            p.waitFor();
        } catch (Exception e) {
            System.out.println("error executing " + cmd[0]);
        }
        
        timeElapsed = System.currentTimeMillis() - start;
        System.out.println("Time elasped: " + timeElapsed);

        System.out.println("waited for subprocess");
    }
}

/*
 output:
 
 Time elasped: 4
 did not wait for subprocess
 waiting..
 Time elasped: 5002
 waited for subprocess
 
*/