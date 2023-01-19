
public abstract class EncryptionDecorator extends Encryption{
	   protected Encryption decoratedEncryption;
	   
	   protected EncryptionDecorator(Encryption decoratedEncryption){
	      this.decoratedEncryption = decoratedEncryption;			//constructor
	   }
	 
	    protected String Encrypt(int i, String message) {
	    	return decoratedEncryption.Encrypt(i, Encrypt(i,message));	//new logic of using new encrypt method
	    }
	    protected String Decrypt(int i, String message) {
	    	return Decrypt(i, decoratedEncryption.Decrypt(i,message));	//new logic of using new decrypt method
	    }

}
