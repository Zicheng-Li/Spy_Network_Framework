import java.util.ArrayList;
import java.util.List;

public class HomeBase extends Entity{    
    private Context c;                          // This is the Context variable.
    private static HomeBase instance;           // This is the singleton instance.

    private List<FieldBase> FieldBases = new ArrayList<FieldBase>();   // Create a list of all FieldBase Observer.

    private HomeBase(Context context) {         // HomeBase Constructors private
        c=context;
    }

    protected static HomeBase getInstance(Context context) {        // The static method that controls access to the HomeBase using Singleton Pattern
        if (instance == null) {
            instance = new HomeBase(context);
        }
        return instance;
    }

    protected void start() {               // start function to start passing the scheme
        notifyall();
    }

    protected void get() {             // A get function so each Observer can get the Encryption Scheme.
        System.out.println("Encryption function: " + c.EnFunction() + "Decryption function: " + c.DeFunction() + "Key: "+ c.Key());
    }

    protected void set(int i) {             // client can use this set function to reset the key.
        c.changeKey(i);
        notifyall();
    }

    protected void subscribe(FieldBase fieldBase) {   // If a FieldBases was created or go light, the FieldBases Class will recall this function to subscribe.
        FieldBases.add(fieldBase);
    }

    protected void unsubscribe(FieldBase fieldBase) { // If a FieldBases go dark, the FieldBases Class will recall this function to unsubscribe.
        FieldBases.remove(fieldBase);
    }

    protected void notifyall() {                      // This is the function to notify all Observers once a change of Encryption Scheme made.
        for (FieldBase fieldBase : FieldBases) {
            fieldBase.update();
        }
    }
    
    protected String Encrypt(int i, String message) {						//get encrypt method for sending msg
    	return c.Encrypt(i, message);
    }
    
    protected String Decrypt(int i, String message) {						//get encrypt method for sending msg
    	return c.Decrypt(i, message);
    }
    
    protected int Key() {													//get key for encrypt & decrypt
        return c.Key();
    }
    
    @Override
	protected void sendMessage(Entity sender, Entity reciver, String text) {	//send message
    	try {
    		reciver.reciveMessage(sender,reciver, Encrypt(c.Key(), text));	//if entered something else(other than entity) as receiver, raise exception
    	}
    	catch(Exception e) {
    		System.out.println("Reciver Not Found!");
    		return;
    	}
		System.out.println("Message send!");								//otherwise successfully send
		
	}

	@Override
	protected void reciveMessage(Entity sender, Entity reciver, String text) { 	    //receive message
		System.out.println("Message recive! :"+Decrypt(Key(), text));				//decrypt message
	}
}