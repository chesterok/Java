public class Iterator {
    private int[] pointer;
    private int limit;
    private int current;
    private int maxSize;

    public Iterator(int limit) {
        pointer = new int[limit + 1];
        this.limit = limit;
        this.current = 1;
        this.maxSize = 1;

        pointer[current] = 2;
    }

    public void next() {
        if ( over() ) {
            return;
        }

        if ( maxSize == current ) {
            for ( int i = pointer[current] + 1; i <= i; i++ ) {
                boolean prime = true;

                for ( int j = 2; j <= Math.sqrt(i); j++ )  {
                    if ( i % j == 0 ) { 
                        prime = false;
                        break;
                    }
                }
                if ( prime ) {
                    current += 1;
                    maxSize = current;
                    pointer[current] = i;
                    break;
                }
            }
        } else {
            current += 1;
        }
    }

    public void reset() {
        current = 1;
    }

    public void jumpToIndex(int index) throws InvalidIndexException {
        if ( index < 1 ) {
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
    public int getValueAtIndex(int index) throws InvalidIndexException {
        int tempCurrent = current;

        jumpToIndex(index);

        index = current;
        current = tempCurrent;

        return pointer[index];
    }

    public void previous() {
        if ( less() ) {
            return;
        }
        current -= 1;
    }

    boolean less() {
        return current < 0;
    }

    boolean over() {
        return current >= limit;
    }

    int getValue() {
        return pointer[current];
    }
}
