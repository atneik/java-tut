public class MainClass {
    public static void main(String args[]) {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        String cmd[] = {"ls","javac MainClass"};
        try {
            p = r.exec(cmd[0]);
            p.waitFor();
        } catch (Exception e) {
            System.out.println("error executing " + cmd[0]);
        }
        System.out.println(cmd[0] + " returned " + p.exitValue());
        
        try {
            p = r.exec(cmd[1]);
            p.waitFor();
        } catch (Exception e) {
            System.out.println("error executing " + cmd[1]);
        }
        System.out.println(cmd[1] + " returned " + p.exitValue());
    }
}

/*
 output:
 
 ls returned 0
 javac MainClass returned 1
 
*/