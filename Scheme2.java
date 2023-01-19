public class Scheme2 extends Encryption {   // This is a demo Scheme

    private int key=9;

    @Override
    protected String Encrypt(int i, String message) {
        return "#2 en test, ";
    }

    @Override
    protected String Decrypt(int i, String message) {
        return "#2 de test, ";
    }

    @Override
    protected String getEnFunction() {      // To get the encryption funtion
        return Encrypt(key, message);
    }

    @Override
    protected String getDeFunction() {      // To get the decryption function
        return Decrypt(key, message);
    }

    @Override
    protected int getKey() {                // To get the key
        return key;
    }

    @Override
    protected void setKey(int i) {          // Set the key
        key=i;
    }
    
}
