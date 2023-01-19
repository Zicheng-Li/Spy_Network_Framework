public class Scheme1 extends Encryption {  // This is a demo Scheme

    private int key=6;
    
    @Override
    protected String Encrypt(int i, String s) {
        return "This is a Encryption Funtion, ";
    }

    @Override
    protected String Decrypt(int i, String s) {
        return "This is a Decryption Function, ";
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
    protected void setKey(int i) {      // Set the key
        key=i;
    }
    
}
