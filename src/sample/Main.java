package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //b1按钮
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
        //text标签
        TextField text=new TextField();
        text.setText("请输入账号");
        text.setLayoutX(200);
        text.setLayoutY(100);
        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("asdssd");
            }
        });
       // text.setPrefWidth(200);
       // text.setPrefHeight(100);

        text.setFont(Font.font(12));

       // Background bk1= new Background(
       //         new BackgroundFill(Paint.valueOf("#8A2BE2"),
        //        new CornerRadii(20),
        //        new Insets(10)));
       // text.setBackground(bk1);
                //text设置七个以下
        text.setPromptText("请输入7个字以下");
        text.setFocusTraversable(false);
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
                if(newValue.length()>7)
                {
                    text.setText(oldValue);
                }
            }
        });


        //password设置
        PasswordField ptext=new PasswordField();
        ptext.setLayoutX(200);
        ptext.setLayoutY(125);
        ptext.setText("输入密码");
        //label
        Label label=new Label("我是账号：");
        label.setLayoutX(150);
        label.setLayoutY(105);
        label.setTextFill(Paint.valueOf("red"));

        Label label2=new Label("我是密码：");
        label2.setLayoutX(150);
        label2.setLayoutY(125);


        //root
        Group root1=new Group();

        root1.getChildren().add(b1);
        root1.getChildren().add(text);
        root1.getChildren().add(ptext);
        root1.getChildren().add(label);
        root1.getChildren().add(label2);
        Scene scene=new Scene(root1);

        //快捷键
        KeyCombination kc1=new KeyCodeCombination(KeyCode.O,KeyCombination.SHIFT_DOWN,KeyCombination.ALT_ANY);
        Mnemonic mnemonic=new Mnemonic(b1,kc1);
        scene.addMnemonic(mnemonic);

        //场景设置
        primaryStage.setScene(scene);

        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(600);
        primaryStage.show();
    }
 


    public static void main(String[] args) {
//主方法设置
        launch(Main.class,args);
    }
}
