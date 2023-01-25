public class Camera {
    private int X;
    private int Y;

    private int Time;

    public Camera(int x, int y) {
        this.X = x;
        this.Y = y;
        this.Time=0;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x) {
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }

    public void update (int time,int speed) {
        if (this.X <= -600) {
                this.X = 0;
            } else {
                this.X=this.X-(3+speed*2);
            }
        }

    @Override
    public String toString() {
        return "Camera{" + "X=" + X + ", Y=" + Y + '}';
    }
}
