public class Iterator {
    private int[] pointer;
    private int lessLimit, overLimit;
    private int current;
    private int maxSize;

    public Iterator(int lessLimit, int overLimit) throws InvalidIndexException {
        this.lessLimit = lessLimit;
        this.overLimit = overLimit;

        if ( lessLimit > overLimit ) {
            throw new InvalidIndexException();
        }

        pointer = new int [Math.abs(lessLimit) + Math.abs(overLimit) + 1];

        pointer[0] = 0;
        pointer[1] = 1;

        for ( int i = 1; i <= Math.abs(lessLimit); i++ ) {
                pointer[i+1] = pointer[i] + pointer[i-1];
        }

        current = lessLimit;
        maxSize = Math.abs(lessLimit);
    }

    public void next() {
        if ( over() ) {
            return;
        }
        current += 1;
        if ( maxSize <= current ) {
            maxSize += 1;
            if ( current > 1 ) {
                pointer[current] = pointer[current-1] + pointer[current-2];
            }
        }
    }

    public void previous() {
        if ( less() ) {
            return;
        }
        current -= 1;
    }

    public boolean over() { 
        return current >= overLimit;
    }

    public boolean less() { 
        return current <= lessLimit;
    }

    public void reset() {
       current = lessLimit; 
    }

    public int getValue() {
        if ( current < 0 ) {
            int newCurrent = current;

            newCurrent *= -1;
            if ( newCurrent % 2 == 0 ) {

                return pointer[newCurrent] * -1;
            }

            return pointer[newCurrent];
        }

        return pointer[current];
    }

    public int getValueAtIndex(int index) throws InvalidIndexException {
        int tempCurrent = current;

        jumpToIndex(index);
        index = getValue();
        current = tempCurrent;

        return index;
    }

    public void jumpToIndex(int index) throws InvalidIndexException {
        if ( index < lessLimit || index > overLimit ) {
            throw new InvalidIndexException();
        }            
        if ( index > maxSize ) {
            current = maxSize;

            for ( int i = maxSize; i < index; i++ ) {
                next();
            }
        } else {
            current = index;
        }
    }

}

