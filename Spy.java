public abstract class Spy extends Entity{    // abstract class for spies
    protected FieldBase fieldbase;
    protected abstract void update();
	protected abstract String Encrypt(int i, String message);
	protected abstract String Decrypt(int i, String message);
	protected abstract int Key();
    
}
