import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class test {

  static PrintStream    out = System.out; 
  static BufferedReader in  = 
    new BufferedReader(new InputStreamReader(System.in));

  static class RderThread extends Thread {
    public BufferedReader in;
    public RderThread(InputStream someIn) {
      in = new BufferedReader(new InputStreamReader(someIn));
    }
    public void run() {
      try {
        String line;
        while ( (line = in.readLine()) != null)
          out.println(line);
      } catch (Exception e) {
        e.printStackTrace();
      } 
    } // EndMethod run       
  } // EndClass RderThread

  public static void main(String argv[]) throws Exception {
    while(true) {
      out.print("Merci d'entrer votre commande ici -> ");
      String line = in.readLine();
      switch (line) {
        case "aide": 
          out.println("Je ne peux pas vous aider.");
          break;
      default:
        out.println("A vos ordres.");
        Process proc = Runtime.getRuntime().exec(line);
        Thread t1 = new RderThread(proc.getInputStream());
        Thread t2 = new RderThread(proc.getErrorStream());
        t1.start(); t2.start();
        t1.join() ; t2.join() ;
        proc.waitFor();
      } // End switch
    } // EndWhile
  } // EndMethod main

} // EndClass MyOwnShell2
