public class Package{
    public static final int DEF_TRACK_NUM = 10000000;

    public static final int STATUS_NONE = 0;
    public static final int STATUS_PACKED = 1;
    public static final int STATUS_SENT = 2;
    public static final int STATUS_ARRIVED = 3;
    public static final int STATUS_DELIVERED = 4;

    private Person _recipient;
    private int _truckNum;
    private int _status;   

    public Package(Person recipient, int trackNum){
        if (trackNum >= 10000000 && trackNum <= 99999999) {
        _trackNum = trackNum; 
        } 

        else {
        _trackNum = DEF_TRACK_NUM; 
        }

        _status = STATUS_NONE;
        

    }
}