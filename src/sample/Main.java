package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Button b1= new Button("B1");

        b1.setLayoutX(100);
        b1.setLayoutY(100);

        b1.setPrefSize(400,200);
        b1.setFont(Font.font(40));
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("B1单击事件");
            }
        });
        b1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    if(event.getClickCount()==2){
                        System.out.println("敲击两次");

                    }
                }
            }
        });
      b1.setOnKeyPressed(new EventHandler<KeyEvent>() {
          @Override
          public void handle(KeyEvent event) {
            if (event.getCode().getName().equals(KeyCode.A.getName()))
            {
                System.out.println("按下=" + event.getCode().getName());
            }
          }
      });
  b1.setOnKeyReleased(new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent event) {
          if (event.getCode().getName().equals(KeyCode.A.getName()))
          {
              System.out.println("释放=" + event.getCode().getName());
          }
      }
  });
        TextField text=new TextField();
        text.setText("这是文本");
        text.setLayoutX(100);
        text.setLayoutY(100);
        text.setFont(Font.font(14));
    //    text.setBackground();




        Group root1=new Group();

        root1.getChildren().add(b1);
        root1.getChildren().add(text);
     //   root1.setLayoutX(200);

        Scene scene=new Scene(root1);


        KeyCombination kc1=new KeyCodeCombination(KeyCode.O,KeyCombination.SHIFT_DOWN,KeyCombination.ALT_ANY);
        Mnemonic mnemonic=new Mnemonic(b1,kc1);
        scene.addMnemonic(mnemonic);


        primaryStage.setScene(scene);

        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(600);
        primaryStage.show();
    }
 

    public static void main(String[] args) {

        launch(Main.class,args);
    }
}
