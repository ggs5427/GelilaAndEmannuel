
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket client;
    private Scanner in;
    private PrintStream out;
    private boolean go;

    private synchronized boolean goodToGo(){
        return this.go;
    }

    private synchronized void stop(){
        this.go = false;
    }

    public Client(String host, int port) throws IOException {
        this.client=new Socket(host,port);
        this.in = new Scanner(client.getInputStream());
        this.out = new PrintStream(client.getOutputStream());
        this.go = true;

        String request = this.in.next();
        String args = this.in.nextLine();
        //do the protocol thingy here
    }

    public void close() {
        try {
            this.client.close();
        }
        catch( IOException ioe ) {
            // squash
        }
        //this.board.close();
    }

}
