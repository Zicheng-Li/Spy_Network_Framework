public class spies extends Spy {
	
    private boolean status = true;
    
    protected spies(FieldBase fieldbase) {    // spies Constructors
        this.fieldbase = fieldbase;
        this.fieldbase.subscribe(this);
    }

    protected void dead() {                   // Call this function when a spy died.
        fieldbase.unsubscribe(this);
        status = false;
    }
        
    @Override
    protected void update() {                 // This is the function to update the spy once a change of Encryption Scheme made.
        fieldbase.get();
    }
    
    
    protected String Encrypt(int i, String message) {		//get encrypt method for sending msg
    	return fieldbase.Encrypt(i, message);
    }
    
    @Override
    protected String Decrypt(int i, String message) {		//get decrypt method for receiving msg
    	return fieldbase.Decrypt(i, message);
    }
    
    @Override
    protected int Key() {									//get key for encrypt & decrypt
        return fieldbase.Key();
    }
    
    @Override
 	protected void sendMessage(Entity sender, Entity reciver, String text) {	//send message
     	if(!status){
 			System.out.println("Unable to send message");					//if died then unable to send
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
			System.out.println("Unable to recive message");					//if died then unable to receive
			return;
		}
 		System.out.println("Message recive! :"+ Decrypt(Key(), text));		//decrypt the msg
 	}
}
