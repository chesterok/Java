public class Date {
    protected int day;
    protected int month;
    protected int year;

    private void validate(int day, int month, int year) throws InvalidDateException {
        if ( day > 31 || day < 1 ) {
            throw new InvalidDateException("Incorrect day");    
        }        
        if ( month > 12 || month < 1 ) {
            throw new InvalidDateException("Incorrect month");    
        }
        if ( year < 0 ) {
            throw new InvalidDateException("Incorrect year");    
        }
        if ( month == 2 ) {
            if ( year % 4 == 0 ) {
                if ( day > 29 ) {
                    throw new InvalidDateException("In leap year february has 29 days");
                }
            } else {
                if ( day > 28 ) {
                    throw new InvalidDateException("In normal year february has 28 days");
                }
            }       
        }
        if ( month == 4 || month == 6 || month == 9 || month == 11 ) {
            if ( day > 30 ) {
                throw new InvalidDateException("In this month can not be 31 day");
            }
        }
    }

    public Date(int day, int month, int year) throws InvalidDateException {
        validate(day, month, year);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date() throws InvalidDateException {
        this(1, 1, 1970);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        if ( day < 10 ) {
            out.append("0");
        }
        out.append(day + ".");
        if ( month < 10 ) {
            out.append("0");
        }
        out.append(month + "." + year);

        return out.toString();
    }
}
