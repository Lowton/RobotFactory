package headfirst.designpatterns.factory.robofactory.parts.manipulators;

public abstract class Manipulators {
    int count;
    String defenition;

    public Manipulators(int count){
        this.count = count;
    }

    @Override
    public String toString() {
        return defenition;
    }

    public int getCount() {
        return count;
    }

    public String getDefenition() {
        return defenition;
    }
}
