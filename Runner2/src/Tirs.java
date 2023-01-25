import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Tirs extends AnimatedThing{
    public Tirs(String file, int x, int y, int index,int offsety, Pane pane) {
        super(file, x, y, index,offsety, pane);

    }

    public ArrayList<Enemy> updateEnemies(ArrayList<Enemy> Enemies,Pane pane){
        ArrayList<Enemy> Futur=new ArrayList<Enemy>();
        for(Enemy Enemy : Enemies) {
            if (abs(this.Img.getX() - Enemy.Img.getX()) < 77 && this.Img.getY()>240) {
                pane.getChildren().remove(Enemy.Img);
            }
            else{
                Futur.add(Enemy);
            }
        }
        return Futur;
    }

    public boolean updateTir(ArrayList<Enemy> Enemies){
        for(Enemy Enemy : Enemies) {
            if (abs(this.Img.getX() - Enemy.Img.getX()) < 77 && this.Img.getY()>240) {
                return true;
            }
            else{
            }
        }
        return false;
    }

    public void update(){
        if (this.X<600) {
            this.X = this.X + 3;
        }
        this.Img.setViewport(new Rectangle2D(Offsetx, Offsety, Sizex, Sizey));
        this.Img.setX(this.X);
    }
}
