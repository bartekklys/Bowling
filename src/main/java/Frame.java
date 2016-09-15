
public class Frame {
    private int firstRoll = 0;
    private int secondRoll = 0;

    public Frame(int firstRoll, int secondRoll) throws BowlingException {
        if(firstRoll > 10 || secondRoll > 10){
            throw new BowlingException();
        }
        else {
            this.firstRoll = firstRoll;
            this.secondRoll = secondRoll;
        }
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public boolean isSpare(){
        return ((firstRoll + secondRoll) == 10 && firstRoll != 10);
    }

    public boolean isStrike(){
        return firstRoll == 10;
    }

    public int getSum(){
        return firstRoll + secondRoll;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "firstRoll=" + firstRoll +
                ", secondRoll=" + secondRoll +
                '}';
    }
}
