public abstract class FieldBase extends Entity{  // abstract class for FieldBases
    protected HomeBase homebase;
    protected abstract void update();
    protected abstract void get();
    protected abstract void unsubscribe(spies spy);
    protected abstract void subscribe(spies spy);
	protected abstract String Encrypt(int i, String message);
	protected abstract String Decrypt(int i, String message);
	protected abstract int Key();

    
}
