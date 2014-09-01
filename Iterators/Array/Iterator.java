public class Iterator<Type> {
    Type[] array;
    int last;
    int current;

    public Iterator(Type[] pointer, int size) {
        this.last = size - 1;
        this.current = 0;
        this.array = pointer;
    }

    public void next() {
        if ( over() ) {
            return;
        }
        current += 1;
    }

    public void previous() {
        if ( less() ) {
            return;
        }
        current -= 1;
    }

    public void reset() {
        current = 0;
    }

    public boolean over() {
        return current >= last;
    }

    public boolean less() { 
        return current <= 0;
    }

    public Type value() { 
        return array[current];
    }

    public Type getValueAtIndex(int index) throws InvalidIndexException {
        if ( index > last ) {
            throw new InvalidIndexException();
        }

        return array[index];
    }

    public void jumpToIndex(int index) throws InvalidIndexException {
        getValueAtIndex(index);
        current = index;
    }
}
