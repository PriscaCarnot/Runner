import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class StaticThing {
    protected double PosX;
    protected double PosY;
    protected Image Image;
    protected String file;
    protected BackgroundPosition coord;


    public StaticThing(int x, int y, String fileName, Pane group){
    this.PosX=x;
    this.PosY=y;
    this.file=fileName;
    this.coord = new BackgroundPosition(Side.LEFT, this.PosX, false, Side.TOP, this.PosY, false);
     //img = new Background(createImage(this.file,0,0));
    Background img =  new Background(createImage(this.file,x,y));
    group.setBackground(img);
    }

    public Image getImage() {
        return Image;
    }

    private static BackgroundImage createImage(String url, int x, int y) {
        return new BackgroundImage(
                new Image(url),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                new BackgroundPosition(Side.LEFT, x, false, Side.TOP, y, false),
                new BackgroundSize(600, 400, false, false, false, false));
    }
}
