import javafx.scene.layout.Pane;

public class Score {
    protected Number Unit;
    protected Number Deci;
    protected Number Cent;
    protected Number Mill;

    public Score(Pane pane) {
        this.Unit=new Number("numbers.png",550,20,860,600,pane);
        this.Deci=new Number("numbers.png",520,20,860,600,pane);
        this.Cent=new Number("numbers.png",490,20,860,600,pane);
        this.Mill=new Number("numbers.png",460,20,860,600,pane);
    }

    public void update(){
        this.Unit.update();
        if (this.Unit.nb==0){
            this.Deci.update();
            if (this.Deci.nb==0){
                this.Cent.update();
                if(this.Cent.nb==0){
                    this.Mill.update();
                }
            }
        }
    }

}
