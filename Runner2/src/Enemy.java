import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

public class Enemy extends AnimatedThing{
    public Enemy(String file, int x, int y,int index,int offsety, Pane pane) {
        super(file, x, y,index,offsety, pane);
        this.Action=0;

    }

    public void update (int time,int speed){
        if(this.Time>=time){
            this.Time=0;
            if (this.Index==1){
                this.Index=6;
            }
            else{
                this.Index--;
            }
        }
        else{
            this.Time++;
        }
        if (this.X>-90) {
            this.X = this.X - (3+2*speed);

        }
        this.Offsetx=this.Index*86;
        this.Img.setViewport(new Rectangle2D(Offsetx, Offsety, Sizex, Sizey));
        this.Img.setX(this.X);
    }
}
