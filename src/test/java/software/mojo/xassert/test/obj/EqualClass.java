package software.mojo.xassert.test.obj;

public class EqualClass extends SimpleClass {

    public EqualClass(int i) {
        super(i);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EqualClass)) {
            return false;
        }
        EqualClass c = (EqualClass) o;
        return this.getI() == c.getI();
    }

    @Override
    public int hashCode(){
        return this.getI();
    }

}
