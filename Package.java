/**
 * Represents a shipping package with a recipient, tracking number, and status.
 * Provides methods to update status and handle delivery.
 * * @author kayoosh_x
 */

public class Package{
    /** Default tracking number used when an invalid number is provided. */
    public static final int DEF_TRACK_NUM = 10000000;

    /** Main delivery statuses */
    public static final int STATUS_NONE = 0;
    public static final int STATUS_PACKED = 1;
    public static final int STATUS_SENT = 2;
    public static final int STATUS_ARRIVED = 3;
    public static final int STATUS_DELIVERED = 4;

    /** Basic customer data */
    private Person _recipient;
    private int _trackNum;
    private int _status;   

    /** Tracking number validation */
    public Package(Person recipient, int trackNum){
        _recipient = new Person(recipient);
        if (trackNum >= 10000000 && trackNum <= 99999999) {
        _trackNum = trackNum; 
        } 

        else {
        _trackNum = DEF_TRACK_NUM; 
        }

        _status = STATUS_NONE;
    }

    //getters && setters
    /** Gets the recipient of the package (returns a copy) */
    public Person getRecipient() {
        return new Person(_recipient);
    }   

    /** Sets the recipient of the package (stores a copy) */
    public void setRecipient(Person recipient) {
        _recipient = new Person(recipient);
    }     
    
    /** Gets the package tracking number */
    public int getTrackNum() {
        return _trackNum;
    }

    /** Sets the tracking number if it is valid (8 digits) */
    public void setTrackNum(int trackNum) {
        if (trackNum >= 10000000 && trackNum <= 99999999) {
            _trackNum = trackNum;
        }
    }

    /** Gets the current status code. */
    public int getStatus() {
        return _status;
    }

    /** Advances the package status to the next stage */
    public void updateStatus() {
        if (_status < STATUS_DELIVERED) {
            _status++;
        }
    }
    
    /** Returns the string representation of the current status */
    public String getStatusName() {
        switch (_status) {
            case STATUS_NONE: return "NONE";
            case STATUS_PACKED: return "PACKED";
            case STATUS_SENT: return "SENT";
            case STATUS_ARRIVED: return "ARRIVED";
            case STATUS_DELIVERED: return "DELIVERED";
            default: return "";
        }
    }

    /** Checks if the package has been delivered */
    public boolean isDelivered() {
        return _status == STATUS_DELIVERED;
    }

    /** Returns package details as a string */
    public String toString() {
        return "Package " + _trackNum + ", To " + _recipient.toString() + ", Status=" + getStatusName();
    }

    /** Compares this package with another for equality */
    public boolean equals(Package p) {
        return _trackNum == p._trackNum && 
            _status == p._status && 
            _recipient.equals(p._recipient);
    }

    /** Checks if this package was handled after the given package */
    public boolean after(Package p) {
        return p.before(this);
    }

    /** Attempts to deliver the package to a person */
    public boolean deliver(Person p) {
        if (_status == STATUS_ARRIVED && _recipient.equals(p)) {
            _status = STATUS_DELIVERED;
            return true;
        }
        return false;
    }
}
