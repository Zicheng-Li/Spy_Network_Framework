public class Context {   // This is the only class where client to choose different encryption scheme
	
    private Encryption scheme;
    
    // Context Constructors
    protected Context(Encryption scheme) {
        this.scheme=scheme;
    }
    
    //get decrypt function
    protected String DeFunction(){
        return scheme.getDeFunction();
    }

    //get encrypt function
    protected String EnFunction() {
        return scheme.getEnFunction();
    }

    //get key
    protected int Key() {
        return scheme.getKey();
    }

    //change key
    protected void changeKey(int i) {
        scheme.setKey(i);
    }
    
    //encrypt method
    protected String Encrypt(int i, String message) {
    	return scheme.Encrypt(i, message);
    }
    
    //decrypt method
    protected String Decrypt(int i, String message) {
    	return scheme.Decrypt(i, message);
    }
}
