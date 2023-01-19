
public class SchemeDuplicator extends EncryptionDecorator{

	private int key=3;
	
    protected SchemeDuplicator(Encryption decoratedEncryption) {    // Decorator Constructor
		super(decoratedEncryption);								
	}
    
    @Override
    protected String Encrypt(int i, String s) {
        return "This is a Duplicator Encryption Funtion, ";		//making new encrypt
    }

    @Override
    protected String Decrypt(int i, String s) {
        return "This is a Dupicator Decryption Function, ";		//making new decrypt
    }

    @Override
    protected String getEnFunction() {   // To get the encryption funtion
        return Encrypt(key, message);
    }

    @Override
    protected String getDeFunction() {  // To get the decryption function
        return Decrypt(key, message);
    }

    @Override
    protected int getKey() {            // To get the key
        return key;
    }

    @Override
    protected void setKey(int i) {       // Set the key
        key=i;
    }
}
