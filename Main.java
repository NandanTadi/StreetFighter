import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.input.*;
import javafx.scene.media.AudioClip;
import java.net.URL;

public class Main extends Application implements EventHandler<InputEvent> {
    GraphicsContext gc, gc2, gc3;
    AnimateObjects animate;
    Canvas canvas, canvas2, canvas3;
    public int x = 1200, y = 250, x2 = 5, y2 = 240, velX = 0, velY = 0, velX2 = 0, velY2 = 0, count = 1, count2 = 1;
    public int kickcount1 = 60, punchcount1 = 60, throwcount1 = 60, kickcount2 = 60, punchcount2 = 60, throwcount2 = 60;
    public int p1Health = 100, p2Health = 100, rando = 15, counter2 = 0, time = 120, start = 0, keysready = 0,
            objectmove = 1,protect = 1, protect2 = 1;
    Image image, logo, ko, ken, zangief, fighter1, fighter2, rfighter1, rfighter2, main;
    Image fk1, fk2, fp1, fp2, ft1, ft2, rfk1, rfk2, rfp1, rfp2, rft1, rft2;

    public double stand = 5;

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage){
        stage.setTitle("Street Fighter Created By Nandan Tadi");
        Group root2 = new Group();
        Scene scene = new Scene(root2);
        canvas = new Canvas(1326.5, 449);
        canvas2 = new Canvas(1326.5, 200);
        canvas3 = new Canvas(1326.5, 200);
        gc = canvas.getGraphicsContext2D();
        gc2 = canvas2.getGraphicsContext2D();
        gc3 = canvas3.getGraphicsContext2D();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, this);
        scene.addEventHandler(KeyEvent.KEY_RELEASED, this);
        root2.getChildren().addAll(canvas, canvas2, canvas3);
        image = new Image("street.jpg");
        logo = new Image("logo.png");
        ken = new Image("Ken.jpg");
        zangief = new Image("zangief.jpg");
        fighter1 = new Image("fighter1.gif");
        fighter2 = new Image("fighter2.gif");
        rfighter1 = new Image("rfighter1.gif");
        rfighter2 = new Image("rfighter2.gif");

        fk1 = new Image("kenkick.gif");
        fp1 = new Image("kenpunch.gif");
        ft1 = new Image("kenthrow.gif");
        rfk1 = new Image("rkenkick.gif");
        rfp1 = new Image("rkenpunch.gif");
        rft1 = new Image("rkenthrow.gif");

        fk2 = new Image("zankick.gif");
        fp2 = new Image("zangiefpunch.gif");
        ft2 = new Image("zanthrow.gif");
        rfk2 = new Image("rzankick.gif");
        rfp2 = new Image("zangiefpunch.gif");
        rft2 = new Image("rzanthrow.gif");

        main = new Image("resize.png");


        animate = new AnimateObjects();
        animate.start();
        stage.setScene(scene);
        stage.show();

        URL resource = getClass().getResource("streetmusic.wav");
        AudioClip clip = new AudioClip(resource.toString());
        clip.play();

    }

    public class AnimateObjects extends AnimationTimer {
        public void handle(long now) {

			Rectangle2D leftwall = new Rectangle2D(0, 0, 1, 450);
			Rectangle2D rightwall = new Rectangle2D(1329, 0, 1, 450);
            Rectangle2D kick1 = new Rectangle2D(x, y, 150, 200);
            Rectangle2D punch1 = new Rectangle2D(x, y, 150, 200);
            Rectangle2D kick2 = new Rectangle2D(x2, y2, 200, 200);
            Rectangle2D punch2 = new Rectangle2D(x2, y2, 250, 200);
            Rectangle2D Ifighter2 = new Rectangle2D(x2 + 10, y2, 130, 200);
            Rectangle2D Ifighter1 = new Rectangle2D(x + 10, y, 100, 200);

            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.drawImage(image, 0, 0);
            gc.drawImage(logo, 600, 50);
            gc.drawImage(ken, 1250, 0);
            gc.drawImage(zangief, 0, 0);


            gc.setFill( Color.BLACK);
            gc.setStroke( Color.BLACK );
            gc.setLineWidth(2);
            Font font = Font.font(";Arial", FontWeight.NORMAL, 25);
            gc.setFont(font);
            gc.fillText("TIME LEFT: " + (120-(counter2/60)), 615, 20);
            gc.strokeText("TIME LEFT: " + (120-(counter2/60)), 615, 20);

            gc.setFill( Color.BLACK);
            gc.setStroke( Color.BLACK );
            gc.setLineWidth(2);
            Font font3 = Font.font(";Arial", FontWeight.NORMAL, 40);
            gc.setFont(font3);
            gc.fillText(p2Health + "%", 100, 50);
            gc.strokeText(p2Health + "%", 100, 50);

            gc.setFill( Color.BLACK);
            gc.setStroke( Color.BLACK );
            gc.setLineWidth(2);
            Font font4 = Font.font(";Arial", FontWeight.NORMAL, 40);
            gc.setFont(font4);
            gc.fillText(p1Health + "%", 1140, 50);
            gc.strokeText(p1Health + "%", 1140, 50);

            counter2++;
            if(counter2 / 60 == 120) {

                gc.setFill( Color.RED);
                gc.setStroke( Color.RED );
                gc.setLineWidth(2);
                Font font5 = Font.font(";Arial", FontWeight.NORMAL, 40);
                gc.setFont(font5);
                gc.fillText("TIE GAME! HIT R TO RESTART", 1140, 50);
                gc.strokeText("TIE GAME! HIT R TO RESTART", 1140, 50);

            }

            if (x > x2) {
                if(kickcount1 < 60) {
                    kickcount1++;
                    gc.drawImage(fk1, x, y);
                    if(protect == 0){
                        p2Health =  (p2Health+0);}
                    else if((kick1.intersects(Ifighter2)) && (kickcount1 == 1)){
                        p2Health-=stand;}
                    protect = 1;
                    protect2 = 1;
                }
                else if(punchcount1 < 60){
                    punchcount1++;
                    gc.drawImage(fp1, x, y);
                    if(protect == 0)
                        p2Health =  (p2Health+0);
                    else if(punch1.intersects(Ifighter2) && punchcount1 == 1){
                        p2Health-=stand;}
                    protect = 1;
                    protect2 = 1;
                }
                else if(throwcount1 < 60){
                    throwcount1++;
                    gc.drawImage(ft1, x, y);
                }
                else
                    gc.drawImage(fighter1, x, y);
                if(kickcount2 < 60) {
                    kickcount2++;
                    gc.drawImage(fk2, x2, y2-30);
                    if(protect2 == 0)
                        p1Health =  (p1Health+0);
                    else if(kick2.intersects(Ifighter1) && kickcount2 == 1){
                        p1Health-=stand;}
                    protect = 1;
                    protect2 = 1;
                }
                else if(punchcount2 < 60){
                    punchcount2++;
                    gc.drawImage(fp2, x2, y2);
                    if(protect2 == 0)
                        p1Health =  (p1Health+0);
                    else if(punch2.intersects(Ifighter1) && punchcount2 == 1){
                        p1Health-=stand;}
                    protect = 1;
                    protect2 = 1;
                }
                else if(throwcount2 < 60){
                    throwcount2++;
                    gc.drawImage(ft2, x2, y2);
                }
                else
                    gc.drawImage(fighter2, x2, y2);
            }
            if (x < x2) {
                if(kickcount1 < 60) {
                    kickcount1++;
                    gc.drawImage(rfk1, x, y);
                    if(protect == 0)
                        p2Health =  (p2Health+0);
                    else if(kick1.intersects(Ifighter2) && kickcount1 == 1){
                        p2Health-=stand;}
                    protect = 1;
                    protect2 = 1;
                }
                else if(punchcount1 < 60){
                    punchcount1++;
                    gc.drawImage(rfp1, x, y);
                    if(protect == 0)
                        p2Health =  (p2Health+0);
                    else if(punch1.intersects(Ifighter2) && punchcount1 == 1){
                        p2Health-=stand;}
                    protect = 1;
                    protect2 = 1;
                }
                else if(throwcount1 < 60){
                    throwcount1++;
                    gc.drawImage(rft1, x, y);
                }
                else
                    gc.drawImage(rfighter1, x, y);
                if(kickcount2 < 60) {
                    kickcount2++;
                    gc.drawImage(rfk2, x2, y2-30);
                    if(protect2 == 0)
                        p1Health =  (p1Health+0);
                    else if(kick2.intersects(Ifighter1) && kickcount2 == 1){
                        p1Health-=stand;}
                    protect = 1;
                    protect2 = 1;
                }
                else if(punchcount2 < 60){
                    punchcount2++;
                    gc.drawImage(rfp2, x2, y2);
                    if(protect2 == 0)
                        p1Health =  (p1Health+0);
                    else if(punch2.intersects(Ifighter1) && punchcount2 == 1){
                        p1Health-=stand;}
                    protect = 1;
                    protect2 = 1;
                }
                else if(throwcount2 < 60){
                    throwcount2++;
                    gc.drawImage(rft2, x2, y2);
                }
                else
                    gc.drawImage(rfighter2, x2, y2);
            }


            x += velX;
            y += velY;
            x2 += velX2;
            y2 += velY2;

            if (y <= 75) {
                count++;
                velY = 4 * count;
            }
            if (y == 250) {
                count = 0;
                velY = 0;
            }

            if (y2 <= 75) {
                count2++;
                velY2 = 4;
            }
            if (y2 == 240) {
                count2 = 0;
                velY2 = 0;
            }

            if(p1Health == 0){
                gc.setFill( Color.RED);
                gc.setStroke( Color.RED );
                gc.setLineWidth(3);
                Font font2 = Font.font(";Impact", FontWeight.NORMAL, 45);
                gc.setFont(font2);
                gc.fillText("GAME OVER! PLAYER 2 WINS" , 400, 150);
                gc.strokeText("GAME OVER! PLAYER 2 WINS" , 400, 150);


                gc.setFill( Color.RED);
                gc.setStroke( Color.RED );
                gc.setLineWidth(3);
                Font font8 = Font.font(";Impact", FontWeight.NORMAL, 45);
                gc.setFont(font8);
                gc.fillText("HIT R TO RESTART!" , 400, 200);
                gc.strokeText("HIT R TO RESTART!" , 400, 200);

                x = -1000;
                keysready = 0;
                if(counter2 == (counter2+=10)){
                    x = 1150;y = 250;x2 = 5;y2 = 240;velX = 0;velY = 0;velX2 = 0;velY2 = 0;count = 0;count2 =0;
                    counter2 = 0; p1Health = 100; p2Health = 100;start = 0;keysready = 0;}

            }
            if(p2Health == 0){
                gc.setFill( Color.RED);
                gc.setStroke( Color.RED );
                gc.setLineWidth(3);
                Font font2 = Font.font(";Impact", FontWeight.NORMAL, 45);
                gc.setFont(font2);
                gc.fillText("GAME OVER! PLAYER 1 WINS" , 400, 150);
                gc.strokeText("GAME OVER! PLAYER 1 WINS" , 400, 150);



                gc.setFill( Color.RED);
                gc.setStroke( Color.RED );
                gc.setLineWidth(3);
                Font font8 = Font.font(";Impact", FontWeight.NORMAL, 45);
                gc.setFont(font8);
                gc.fillText("HIT R TO RESTART!" , 400, 200);
                gc.strokeText("HIT R TO RESTART!" , 400, 200);

                x2 = -1000;
                keysready = 0;

                if(counter2 == (counter2+=10)){
                    x = 1150;y = 250;x2 = 5;y2 = 240;velX = 0;velY = 0;velX2 = 0;velY2 = 0;count = 0;count2 =0;
                counter2 = 0; p1Health = 100; p2Health = 100;start = 0;keysready = 0;}
            }

            //TESTING VAR
            gc.fillRect(0, 0, 1, 450);
            gc.fillRect(1326, 0, 1, 450);
            gc.fillRect(0, 448, 1326.5, 1);



            gc.setFill(Color.BLACK);

            if (Ifighter1.intersects(leftwall) || Ifighter1.intersects(rightwall))
                velX = 0;
            if (Ifighter2.intersects(leftwall) || Ifighter2.intersects(rightwall))
                velX2 = 0;

            if(start == 0)
                gc.drawImage(main,0, 0);

        }
    }

    public void handle(final InputEvent event) {
        KeyEvent key = (KeyEvent) event;
        if (event instanceof KeyEvent) {
            if(key.getEventType() == KeyEvent.KEY_PRESSED) {

                if (key.getCode() == KeyCode.R) {
                    x = 1150;y = 250;x2 = 5;y2 = 240;velX = 0;velY = 0;velX2 = 0;velY2 = 0;count = 0;count2 =0;
                    counter2 = 0; p1Health = 100; p2Health = 100;start = 0;keysready = 0;
                }

                if(start == 0)
                if(key.getCode() == KeyCode.SPACE){
                    start = 1;
                    counter2 = 0;
                    keysready = 1;
                }

                if(keysready == 1){
                //PLAYER 1 MOVES
                if(key.getCode() == KeyCode.DOWN) protect2 = 0;
                if (key.getCode() == KeyCode.LEFT) velX = -4;
                if (key.getCode() == KeyCode.RIGHT) velX = 4;
                if (key.getCode() == KeyCode.UP) {
                    if (y == 250)
                        velY = -4;
                }
                if (key.getCode() == KeyCode.M) kickcount1 = 0;
                if (key.getCode() == KeyCode.N) punchcount1 = 0;
                if (key.getCode() == KeyCode.B) {
                    throwcount1 = 0;
                    objectmove = 1;
                }

                //PLAYER 2 MOVES
                if(key.getCode() == KeyCode.S) protect = 0;
                if (key.getCode() == KeyCode.A) velX2 = -4;
                if (key.getCode() == KeyCode.D) velX2 = 4;
                if (key.getCode() == KeyCode.W) {
                    if (y2 == 240)
                        velY2 = -4;
                }
                if (key.getCode() == KeyCode.Z) kickcount2 = 0;
                if (key.getCode() == KeyCode.X) punchcount2 = 0;
                if (key.getCode() == KeyCode.C)
                    throwcount2 = 0;
                }
            }
            else if(key.getEventType() == KeyEvent.KEY_RELEASED){
                if (key.getCode() == KeyCode.LEFT)velX = 0;
                if (key.getCode() == KeyCode.RIGHT)velX = 0;
                if(key.getCode() == KeyCode.A)velX2 = 0;
                if(key.getCode() == KeyCode.D)velX2 = 0;
            }
        }
    }
}


