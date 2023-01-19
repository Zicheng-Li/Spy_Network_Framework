public abstract class Encryption {
    protected String message;  //message

    protected abstract String Encrypt(int i, String message);  // encryption funtion.                             
    protected abstract String Decrypt(int i, String message);  // decryption function.

    
    protected abstract String getEnFunction();  // abstract get functions
    protected abstract String getDeFunction();
    protected abstract int getKey();
    
    protected abstract void setKey(int i);   // abstract set key functions
}
