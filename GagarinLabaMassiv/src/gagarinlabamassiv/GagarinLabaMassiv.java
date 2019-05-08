/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gagarinlabamassiv;
//добавить ключи случайные.
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Stack;
class Conteiner {
    int a;
    int b;
    public Conteiner(int a,int b){
           this.a = a;
           this.b = b;
    }
 
    public int getA() {
        return a;
    }
 
    public int getB() {
        return b;
    }
 
    public void setA(int a) {
        this.a = a;
    }
 
    public void setB(int b) {
        this.b = b;
    }
    
    
    
}
public class GagarinLabaMassiv extends Application {
     char [][] massiveKey;
      char [] massiveSourceV;
      char [] massiveSourceH;
      int LKeyV;
      int LKeyH; 
    @Override
    public void start(Stage primaryStage) {   
        TextArea ta1 = new TextArea("HELLO_WORLD_JECK");
        //1 бокс
        VBox vb1 = new VBox();
        Button btn1 = new Button(" Зашифровать ");
        
        Button btn2 = new Button("Расшифровать");
        vb1.setSpacing(10);
        vb1.setPadding(new Insets(10,10,10,10));
        vb1.getChildren().addAll(btn1,btn2,ta1);
         
         TextField keyH = new TextField();
         TextField keyV = new TextField();
        Label LakeyH = new Label("Введите  ключ горизонтальный");
        Label LakeyV = new Label("Введите   ключ вертикальный");
        vb1.getChildren().addAll(LakeyH,keyH,LakeyV,keyV);
 
        TextArea ta2 = new TextArea();
        Button btn5 = new Button(" Сгенерировать случайные ключи ");
        vb1.getChildren().add(btn5);
        //2 бокс
        VBox vb2  = new VBox();
        Button btn3 = new Button();
        btn3.setText("Очистить");
        Button btn4 = new Button();
        btn4.setText("Выход");
        vb2.setSpacing(10);
        vb2.getChildren().add(btn3);
        vb2.getChildren().add(btn4);
        vb2.setPadding(new Insets(10,10,10,10));
        vb2.getChildren().add(ta2);
        //обработчик событий кнопки
        btn1.setId("btn");
        btn5.setId("btn3");
        btn1.setOnAction (new EventHandler<ActionEvent>() {
            @Override          
            //Первый ключ            
            public void handle(ActionEvent event) {
                //вертик ключ
                String SKeyV = keyV.getText();
                String SKeyH = keyH.getText();
          
                String Text = ta1.getText();
                //Строки , длина вертик ключа.
                    LKeyV = SKeyV.length();
                    LKeyH = SKeyH.length();
                    
                    char [] massivKeyV = SKeyV.toCharArray();
                     
                    char [] massivKeyH = SKeyH.toCharArray();
            int c = 0;
            System.out.println(LKeyH+" "+LKeyV);
            massiveKey = new char [LKeyV][LKeyH];
            
            for (int i=0; i<LKeyV; i++)
                        for (int j=0;j<LKeyH; j++)massiveKey[i][j]=Text.charAt(c++);       
  
            ShowMassive(massiveKey,LKeyV,LKeyH);
            // столбцы
            Code(massivKeyV,massiveKey,LKeyH,LKeyV,true);
            Code(massivKeyH,massiveKey,LKeyV,LKeyH,false);
            
            ShowMassive(massiveKey,LKeyH,LKeyV);
            ta2.setText(Vozvrat(massiveKey,LKeyV,LKeyH));  
            }  
        });
        //Зашифровка
        btn2.setId("btn1");
        btn2.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            public void handle(ActionEvent event) {
                
              //  Decodirovanie(massiveSourceV,massiveKey,false);
              //  Decodirovanie(massiveSourceH,massiveKey,true);
             //   ta2.setText(Vozvrat(massiveKey,LKeyV,LKeyH));
                massiveSourceV = keyV.getText().toCharArray();
                massiveSourceH = keyH.getText().toCharArray();
                Decodirovanie(massiveSourceH,massiveKey,LKeyH,LKeyV,false);
                Decodirovanie(massiveSourceV,massiveKey,LKeyV,LKeyH,true);
                ta2.setText(Vozvrat(massiveKey,LKeyV,LKeyH));
            }    
        });
        btn3.setId("btn2");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ta1.setText(" ");
                ta2.setText(" ");
                keyH.setText(" ");
                keyV.setText(" ");
            }
        });
        btn4.setId("btn3");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ta2.setText("");
            }
        });
         btn3.setId("btn2");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
 
            }
        });
        GridPane Main = new GridPane();
        Main.setId("root");
        Main.add(vb1, 0, 0);
        Main.add(vb2, 1, 0);
        //Рабочая область
        Scene scene = new Scene(Main, 800, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }
    //метод кодирования
      private void Code(char [] massivKeyVH,char [][] massiveKey,int n,int h,boolean c)
         {
             for (int i = 0; i < h; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
        char min = massivKeyVH[i];
        int min_i = i; 
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
        for (int j = i+1; j < massivKeyVH.length; j++) {
            //Если находим, запоминаем его индекс
            if (massivKeyVH[j] < min) {
                min = massivKeyVH[j];
                min_i = j;
            }
        }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
      //  System.out.println(min_i+" "+i);
        if (i != min_i) {
            char tmp = massivKeyVH[i];
            massivKeyVH[i] = massivKeyVH[min_i];
            massivKeyVH[min_i] = tmp;
        if (!c) 
        {
            System.out.println(i + " " + min_i);
            PerestanovkaStlb(massiveKey,i,min_i,n);
        }
        else
        {
            System.out.println(i + "---" + min_i + "  "+n);
            PerestanovkaStr(massiveKey,i,min_i,n); 
        } 
        }
     }     
             for(int i = 0; i < h; i++)System.out.print(massivKeyVH[i]+" ");
             System.out.println();
         }
         private void PerestanovkaStr(char [][] massiveKey,int Str1,int Str2,int weight)
         {
             char tmp;
             
             for (int j = 0;j<weight;j++)
             {
                 
                 tmp = massiveKey[Str1][j];
                 massiveKey[Str1][j]=massiveKey[Str2][j];
                 massiveKey[Str2][j]=tmp;        
             }
             System.out.print("["+Str1+"-"+Str2+"]\n");
          //   System.out.println();
         }
         private void PerestanovkaStlb(char [][] massiveKey,int Stolb1,int Stolb2,int height)
         {
             char tmp;
             for (int j = 0;j<height;j++)
             {
                 tmp = massiveKey[j][Stolb1];
                 massiveKey[j][Stolb1]=massiveKey[j][Stolb2];
                 massiveKey[j][Stolb2]=tmp;  
             }
         }
         private void ShowMassive(char[][] M,int str,int stlb)
         {
 
             for(int i=0;i<str;i++)
                     {
                     }
         }
         
         private String Vozvrat(char [][] massiveKey,int LKeyV,int LKeyH)
         { 
             String Text = "";
             for (int i=0; i<LKeyV; i++)
            {
            for (int j=0;j<LKeyH; j++)
            {
                Text = Text + String.valueOf(massiveKey[i][j]);
                        }
                Text = Text + '\n';
            }
             return Text;
         }
        private void Decodirovanie(char [] massivKeyVH,char [][] massiveKey,int n,int h,boolean c)
        {
          Stack<Conteiner> st = new Stack();
            for (int i = 0; i < n; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
        char min = massivKeyVH[i];
        int min_i = i; 
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
        for (int j = i+1; j < massivKeyVH.length; j++) {
            //Если находим, запоминаем его индекс
            if (massivKeyVH[j] < min) {
                min = massivKeyVH[j];
                min_i = j;
            }
        }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
        if (i != min_i) {
            char tmp = massivKeyVH[i];
            massivKeyVH[i] = massivKeyVH[min_i];
            massivKeyVH[min_i] = tmp;
            st.push(new Conteiner(i,min_i));
         
        }
     }
            while(!st.empty()){
                Conteiner t = st.pop();
                    if (!c)PerestanovkaStlb(massiveKey,t.a,t.b,h);
                            else PerestanovkaStr(massiveKey,t.a,t.b,h); 
            }
            
        }
    public static void main(String[] args) {
        launch(args);
    }   
}