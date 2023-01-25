import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Hero extends AnimatedThing{
    protected int TimeShoot;
    protected ArrayList<Tirs> Tirs;
    public Hero(String file, int x, int y,int index,int offsety,Pane pane) {
        super(file, x, y,index,offsety, pane);
        this.Tirs=new ArrayList<Tirs>();
        this.Action=0;
    }

    public void update (int time){
        if(this.Time>=time){
            this.Time=0;
            if (this.Index==5){
                this.Index=0;
            }
            else{
                this.Index++;
            }
        }
        else{
            this.Time++;
        }
        this.Offsetx=this.Index*83+8;
        if (this.Action == 1){
            this.actionJump();
        }
        else if(this.Action==3){
            this.actionJump();;
        }
        else if (this.Action==2){
            this.actionShoot();
        }

        this.Img.setViewport(new Rectangle2D(Offsetx, Offsety, Sizex, Sizey));
        this.Img.setY(this.Y);
    }
    public void jump(){
        this.Action=1;
        this.Timejump=0;
        this.Offsety=160;
    }

    public void actionJump() {
        if (this.Y <= 250) {
            this.Y = 250 - (13 * this.Timejump - 0.5 * 0.5 * this.Timejump * this.Timejump);
            this.Timejump++;
            this.Index = 0;
            if (this.Timejump >= 16) {
                this.Index = 1;
            }
        }
        else {
            this.Action=0;
            this.Offsety=0;
            this.Y = 250;
        }
        this.Offsetx=this.Index*83+8;
    }

    public void actionShoot(){
        if (this.TimeShoot<15){
            this.TimeShoot++;
            this.Offsetx=1+this.Index*85;
            this.Sizex=80;
        }
        else{
            this.Action=0;
            this.Offsety=0;
            this.Y = 250;
            this.Sizex=77;
        }
    }
    public void shoot(Pane pane){
        if(this.Action==0){
            this.Action=2;
            this.Offsety=325;
        }
        if(this.Action==1){
            this.Action=3;
            this.Offsety=160+325;
        }
        this.TimeShoot=0;

        this.Tirs.add(new Tirs("Heros.png",(int)this.X+this.Sizex,(int)this.Y,6,320,pane));
    }

    public int getTime(){
        return this.Time;
    }
}
