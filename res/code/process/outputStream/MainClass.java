import java.io.OutputStream;

public class MainClass {
    public static void main(String[] argv) throws Exception {
        
        //preparing the shell command; for windows use 'cmd' 
        String[] command = {"sh", "-c", "cat > test.txt"};
        
        //get a subprocess
        Process child = Runtime.getRuntime().exec(command);
        
        //create an outputStream to send data streams to stdin of the process 
        OutputStream out = child.getOutputStream();
        
        //here we are sending
        out.write("Tutorialspoint.com".getBytes());
        out.close();
    }
}

/*
Creates a file 'test.txt' containing: Tutorialspoint.com
 
 
 Note: Do not confuse this with FileOutputStream. The only perpose of using cat as a process and text.txt is to actually see what is being send to the Process.
 */