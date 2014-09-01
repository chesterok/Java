public class Iterator {
    private int first;
    private int last;
    private int step;
    private int value;

    public Iterator(int first, int last, int step) throws InvalidParamException {
        this.first = first;
        this.last = last;
        this.step = step;
        this.value = value;

        if ( first > last || step <= 0 ) {
            throw new InvalidParamException();
        }
    }

    public Iterator() throws InvalidParamException {
        this(0, 20, 2);
    }

    public void next() {
        if ( over() ) {
            return;
        }
        value += step;
    }

    public void previous() {
        if ( less() ) {
            return;
        }
        value -= step;
    }

    public boolean less() {
        return value - step < first;
    }

    public boolean over() {
        return value + step > last;
    }

    public int getValue() {
        return value;
    }

    public void reset() {
        value = first;
    }

    public int getValueAtIndex(int index) throws InvalidIndexException {
        int newValue = first + step * index - step;

        if ( index < 1 || newValue > last ) {
             throw new InvalidIndexException();
        }

        return newValue;
    }

    public void jumpToIndex(int index) throws InvalidIndexException {
        value = getValueAtIndex(index);
    }
}
