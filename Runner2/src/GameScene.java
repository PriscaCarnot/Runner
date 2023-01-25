import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameScene extends Scene {
    public AnimationTimer timer;
    protected Camera Cam;
    protected StaticThing Bckgdimg;
    protected Hero Hero;
    protected ArrayList<Enemy> Enemies;
    protected int time;
    protected double Score;
    protected Score Number;
    protected int Speed;
    protected ImageView start;
    protected Button bstart;
    protected int reset=1;
    public GameScene(Pane pane, int v, int v1, boolean b, int x, int y) {
        super(pane,v,v1,b);
        this.Cam = new Camera(0,0);
        this.Speed=0;
        this.time = 5-this.Speed;
        this.Score=0;

        this.Enemies=new ArrayList<Enemy>();

        this.Bckgdimg= new StaticThing(this.Cam.getX(), this.Cam.getY(), "desert.png",pane);


        this.start=new ImageView("test.png");
        this.start.setViewport(new Rectangle2D(10, 60, 200, 150));
        this.start.setX(150);
        this.start.setY(150);
        this.start.setFitWidth(300);
        this.start.setFitHeight(180);
        pane.getChildren().add(this.start);

        this.bstart = new Button("");
        this.bstart.setLayoutX(140);
        this.bstart.setLayoutY(150);
        this.bstart.setPrefSize(300,150);
        this.bstart.setOpacity(0);
        this.bstart.setOnAction(event ->{
            pane.getChildren().remove(this.start);
            pane.getChildren().remove(this.bstart);
            timer.start();});
        pane.getChildren().add(this.bstart);

        this.Number= new Score(pane);


        this.Hero=new Hero("heros.png",90,250,0,0,pane);

        int NbEnemy= ThreadLocalRandom.current().nextInt(1,4);
        for(int i=0;i<NbEnemy;i++) {
            int position=ThreadLocalRandom.current().nextInt(600,1200);
            this.Enemies.add(new Enemy("enemies2.png", position, 250, 6,0, pane));
        }
        this.timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (reset==0){
                    Enemies.clear();
                    reset++;
                }
                if (Hero.getTime()==0) {

                    if(Score==100 ||Score==250 ||Score==450 ||Score==600){
                        Speed++;
                    }
                    time = 5-Speed;
                    Score++;
                    Number.update();
                }
                Hero.update(time);
                Cam.update(time,Speed);
                Bckgdimg= new StaticThing(Cam.getX(), Cam.getY(), "desert.png",pane);
                ArrayList<Tirs> FuturTirs=new ArrayList<Tirs>();
                for(Tirs Tir: Hero.Tirs){
                    Tir.update();
                    if(Tir.updateTir(Enemies) || Tir.X>=600){
                        pane.getChildren().remove(Tir.Img);
                    }
                    else{
                        FuturTirs.add(Tir);
                    }
                    Enemies = Tir.updateEnemies(Enemies,pane);
                }
                Hero.Tirs=FuturTirs;
                ArrayList<Enemy> futurList= new ArrayList<Enemy>();
                if (Enemies.size()!=0) {
                    for (Enemy Enemy : Enemies) {
                        Enemy.update(time,Speed);
                        if (Hero.getHitBox(Enemy)) {
                            System.out.println("Game Over!");
                            timer.stop();
                            reset_all(pane);
                            init(pane);
                            break;
                        }
                        if (Enemy.Img.getX() > -90) {
                            futurList.add(Enemy);
                        }
                    }
                    Enemies=futurList;
                }
                else{
                    int NbEnemy= ThreadLocalRandom.current().nextInt(1,4);
                    for(int i=0;i<NbEnemy;i++) {
                        int position=ThreadLocalRandom.current().nextInt(600,1200);
                        Enemies.add(new Enemy("enemies2.png", position, 250, 6,0, pane));
                    }
                }
            /*if (Hero.getTime()==0) {

                if(Score==100 ||Score==250 ||Score==450 ||Score==600){
                    Speed++;
                }
                time = 5-Speed;
                Score++;
                Number.update();
            }*/
            }
        };
        /*this.bstart = new Button("");
        this.bstart.setLayoutX(140);
        this.bstart.setLayoutY(150);
        this.bstart.setPrefSize(300,150);
        this.bstart.setOpacity(0);
        this.bstart.setOnAction(event ->{
            pane.getChildren().remove(this.start);
            pane.getChildren().remove(this.bstart);
            timer.start();});
        pane.getChildren().add(this.bstart);*/
        this.setOnMouseClicked( (event)->{
            Hero.jump();
        }
        );

        this.setOnKeyPressed(event ->{
            if (event.getCode()== KeyCode.SPACE){
                Hero.shoot(pane);
            }
        });
    }

    public void init(Pane pane){

        this.Number=new Score(pane);
        this.Cam = new Camera(0,0);
        this.reset=0;
        this.Speed=0;
        this.time=5-this.Speed;
        this.Score=0;
        this.Hero=new Hero("heros.png",90,250,0,0,pane);
        pane.getChildren().add(this.start);
        this.bstart.setOnAction(event ->{
            pane.getChildren().remove(this.start);
            pane.getChildren().remove(this.bstart);
            timer.start();});
        pane.getChildren().add(bstart);
    }

    public void reset_all(Pane pane){
        pane.getChildren().remove(this.Number.Unit.Img);
        pane.getChildren().remove(this.Number.Deci.Img);
        pane.getChildren().remove(this.Number.Cent.Img);
        pane.getChildren().remove(this.Number.Mill.Img);
        pane.getChildren().remove(this.Hero.Img);
        for(Enemy Enemy: this.Enemies){
            Enemy.Img.setViewport(new Rectangle2D(0, 0, Enemy.Sizex, Enemy.Sizey));
        }
        for (Tirs Tir:this.Hero.Tirs){
            pane.getChildren().remove(Tir.Img);
        }
    }
}
