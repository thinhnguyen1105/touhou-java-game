package bases;

public class FrameCounter {
    int count ;
    int countMax;

    public FrameCounter(int countMax){
        this.count = 0;
        this.countMax = countMax;
    }

    public boolean run (){

        if (count >= countMax){
            return true;
        }
        else{
            count++;
            return false;
        }

    }
    public void reset(){
        count = 0;
    }
}
