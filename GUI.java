
import Client.Client;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GUI extends Application {

    public static int ROWS=7;
    public static int COLS=8;
    private Client serverCon;
    private Scanner in;
    private PrintWriter out;
    private Image black=new Image(getClass().getResourceAsStream("p1black.png"));
    private Image red=new Image(getClass().getResourceAsStream("p2red.png"));
    private GridPane gpane;

    private class newButton extends Button {
        public newButton(){
            ImageView imageV = createImageView("empty.png");
            this.setGraphic(imageV);
        }
        private ImageView createImageView(String filename){
            Image image = new Image(getClass().getResourceAsStream(filename));
            return new ImageView(image);
        }
    }

    public GridPane makeGridPane(){
        this.gpane= new GridPane();

        for(int i=0; i<ROWS;i++){
            for(int j=0;j<ROWS;j++){
                Button button = new newButton();
                gpane.add(button,j,i);
            }
        }
        gpane.setGridLinesVisible(true);
        return gpane;
    }

    public void start(Stage stage){
        GridPane gp = makeGridPane();
        Scene scene = new Scene(gp);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Reversi");
        stage.show();
    }

    /**
     * updates the GUI
     */
    public void refresh(){}

    /**
     * Called by the client class if the state needs to be updated by the GUI
     *
     */
    public void update(){
        if ( Platform.isFxApplicationThread() ) {
            this.refresh();
        }
        else {
            Platform.runLater( () -> this.refresh() );
        }
    }

    /**
     * GUI is closing, so close the network connection.
     */
    @Override
    public void stop()throws IOException {
        this.serverCon.close();
    }

    public static void main(String[] args){

        if (args.length != 2) {
            System.out.println("Usage: java ConnectFourGUI host port");
            System.exit(-1);
        } else {
            Application.launch(args);
        }

    }
}
