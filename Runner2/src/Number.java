import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

public class Number extends AnimatedThing{
    protected int nb;
    public Number(String file, int x, int y, int offsetx, int offsety, Pane pane) {
        super(file, x, y, 0, offsety, pane);
        this.Offsetx=offsetx; //860
        this.Sizex=90;
        this.Sizey=80;
        this.nb=0;
        this.Img.setFitWidth(30);
        this.Img.setFitHeight(28);
        this.Img.setViewport(new Rectangle2D(Offsetx, Offsety, Sizex, Sizey));
    }

    public void update(){
        if (this.Offsetx==860){
            this.Offsetx=50;
        }
        else{
            this.Offsetx=this.Offsetx+90;
        }
        this.nb=(this.nb+1)%10;
        this.Img.setViewport(new Rectangle2D(Offsetx, Offsety, Sizex, Sizey));
    }
}
