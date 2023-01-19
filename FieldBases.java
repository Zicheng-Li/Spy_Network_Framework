import java.util.ArrayList;
import java.util.List;
public class FieldBases extends FieldBase {

    private List<Spy> Spies = new ArrayList<Spy>();  // Create a list of Spy Observer.
    private boolean status = true;                   //a status variable for chekcing is this field base able to receive or send msg
    
    protected FieldBases(HomeBase homebase) {           // FieldBases Constructors
        this.homebase = homebase;
        this.homebase.subscribe(this);
    }

    protected void get() {                             // A get function for all spies to get the Encryption Scheme.
        homebase.get();
    }

    @Override
    protected void update() {                          // This is the function to update all spies once a change of Encryption Scheme made.
        homebase.get();
        for(Spy spy : Spies) {
            spy.update();
        }
    }

    @Override
    protected void unsubscribe(spies spy) {            // If a spy dead, it will recall to this function to remove.
        Spies.remove(spy);
    }

    @Override
    protected void subscribe(spies spy) {              // When we create a spy, it will add this spy to the list.
        Spies.add(spy);
    }

    protected void godark() {                          // FieldBase can call this funtion to go dark, status go false.
        homebase.unsubscribe(this);
        status = false;
    }

    protected void golight() {                         // FieldBase can call this funtion to go light to connect with the HomeBase, status go true.
        homebase.subscribe(this);
        status = true;
    }
    
    @Override
    protected String Encrypt(int i, String message) {    //get encrypt method for sending msg
    	return homebase.Encrypt(i, message);
    }
    
    @Override
    protected String Decrypt(int i, String message) {    //get decrypt method for receiving msg
    	return homebase.Decrypt(i, message);
    }
    
    @Override
    protected int Key() {								//get key for encrypt & decrypt
        return homebase.Key();
    }
    
    @Override
 	protected void sendMessage(Entity sender, Entity reciver, String text) {   //send message
     	if(!status){
 			System.out.println("Unable to send message");					//if go dark then unable to send
 			return;
 		}
     	
     	try {
     		reciver.reciveMessage(sender, reciver, Encrypt(Key(),text));	//if entered something else(other than entity) as receiver, raise exception
     	}
     	catch(Exception e) {
     		System.out.println("Reciver Not Found!");
     		return;
     	}
 		System.out.println("Message send!");								//otherwise successfully send
 		
 	}

 	@Override
 	protected void reciveMessage(Entity sender, Entity reciver, String text) {	//receive message
		if(!status){
			System.out.println("Unable to recive message");					//if go dark then unable to receive
			return;
		}
 		System.out.println("Message recive! :"+Decrypt(Key(), text));			//decrypt the msg
 	}
}
