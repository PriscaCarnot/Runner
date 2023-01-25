import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import static java.lang.Math.abs;

public abstract class AnimatedThing {
    protected ImageView Img;
    protected double X;
    protected double Y;
    protected int Action;
    protected int Index;
    protected int Maxindex;
    protected int Time;
    protected int Timejump;
    protected int Sizex;
    protected int Sizey;
    protected int Offsetx;
    protected int Offsety;

    public AnimatedThing(String file, int x, int y,int index,int offsety, Pane pane) {
        this.Img=new ImageView(file);
        this.Sizex=77;
        this.Sizey=100;
        this.Index=index;
        this.Y=y;
        this.X=x;
        this.Offsetx=this.Index*83+8;
        this.Offsety=offsety;
        this.Time=0;
        this.Img.setViewport(new Rectangle2D(Offsetx, Offsety, Sizex, Sizey));
        this.Img.setX(this.X);
        this.Img.setY(this.Y);
        pane.getChildren().add(this.Img);

    }
    public boolean getHitBox(AnimatedThing Enemy){
        if(abs(this.Img.getX()-Enemy.Img.getX())<50 && Enemy.Img.getY()-this.Img.getY()<20){
            return true;
        }
        return false;
    }
}
