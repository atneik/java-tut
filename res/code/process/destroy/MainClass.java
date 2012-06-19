import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainClass
{
public static void main(String[] args)
{
    try
	        {
    int c;
    long startTime = System.currentTimeMillis();
    Runtime r = Runtime.getRuntime();
    String[] a = { "sleep", "120" };
    Process p = r.exec(a);

    try	        {
    c = p.exitValue();
        System.out.println("bad 1");
        return;
      }
    catch (IllegalThreadStateException itse)
	        {
        // Ignore as this is good here.
      }

    p.destroy();
    c = p.waitFor();

    long endTime = System.currentTimeMillis();

    if (endTime - startTime > 110000L)
      System.out.println("bad 2");

    System.out.println(c != 0 ? "ok" : "bad 3");
      }
    catch (Exception ex)
	        {
    System.out.println(ex.toString());
      }
  }
}

/*
 Output:
 
 ok
 
 */