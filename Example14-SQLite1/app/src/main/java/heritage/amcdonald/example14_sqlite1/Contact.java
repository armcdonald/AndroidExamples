package heritage.amcdonald.example14_sqlite1;

/**
 * Created by Allan on 2015/11/05.
 */
public class Contact {

    //private variables
    int _id;
    String _name;
    String _phoneNumber;

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String name, String _phoneNumber){
        this._id = id;
        this._name = name;
        this._phoneNumber = _phoneNumber;
    }

    // constructor
    public Contact(String name, String _phoneNumber){
        this._name = name;
        this._phoneNumber = _phoneNumber;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getPhoneNumber(){
        return this._phoneNumber;
    }

    // setting phone number
    public void setPhoneNumber(String phoneNumber){
        this._phoneNumber = phoneNumber;
    }
}