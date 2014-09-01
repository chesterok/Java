public class Iterator {
	private int first;
    private int multiplier;
    private int quantity;
    private int value;
    private int currentIndex;

    public Iterator(int first, int multiplier, int quantity) throws InvalidMultiplierException, InvalidFirstException {
    	this.first = first;
    	this.multiplier = multiplier;
    	this.quantity = quantity;
    	this.value = first;
    	currentIndex = 1;

    	if ( multiplier == 0 ) {
	        throw new InvalidMultiplierException();
	    }
	    if ( first == 0 ) {
	        throw new InvalidFirstException();
	    }
    }

    public Iterator() throws InvalidMultiplierException, InvalidFirstException {
    	this(1, 2, 3);
    }

    boolean over() {
	    return currentIndex >= quantity;
	}

	boolean less() {
	    return currentIndex <= 1;
	}

	public void next() {
		if ( over() ) {
			return;
		}
		currentIndex += 1;
		value *= multiplier;
	}

	public void previous() {
		if ( less() ) {
			return;
		}
		currentIndex -= 1;
		value /= multiplier;
	}

	public void reset() {
		value = first;
		currentIndex = 1;
	}

	public int getValue() {
		return value;
	}

	public int getValueAtIndex(int index) throws InvalidIndexException {
	    int newValue = first * (int)Math.pow(multiplier, index - 1);

	    if ( index < 1 || index > quantity ) {
	         throw new InvalidIndexException();
	    }

	    return newValue;
	}

	public void jumpToIndex(int index) throws InvalidIndexException {
	    value = getValueAtIndex(index);
	    currentIndex = index;
	}

}
