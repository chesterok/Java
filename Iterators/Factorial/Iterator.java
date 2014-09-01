public class Iterator {
    private int limit;
    private int current;
    private long value;

    public Iterator(int limit) throws InvalidParamException {
    	this.limit = limit;
    	this.current = 1;
    	this.value = 1;

    	if ( limit < 0 ) {
	        throw new InvalidParamException();
	    }

    }

    public Iterator() throws InvalidParamException {
    	this(10);
    }

    public void next() {
	    if ( over() ) {
	        return;
	    }
	    value *= current;
	    current += 1;
	}

	public void previous() {
	    if ( less() ) {
	        return;
	    }
	    current -= 1;
	    value /= current;
	}

	public void reset() {
	    value = 1;
	    current = 1;
	}

	public boolean over() {
	    return current >= limit;
	}

	public boolean less() {
	    return current <= 1;
	}

	public long getValue() {
		return value;
	}

	public int getValueAtIndex(int index) throws InvalidIndexException {
	    int newValue = 1;

	    if ( index < 0 || index >= limit ) {
	        throw new InvalidIndexException();
	    }

	    for ( int i = 1; i <= index; i++ ) {
	        newValue *= i;
	    }

	    return newValue;
	}

	public void jumpToIndex(int index) throws InvalidIndexException {
	    value = getValueAtIndex(index);
	    current = index + 1;
	}
}
