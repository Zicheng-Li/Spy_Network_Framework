public abstract class Entity {
	//two abstract method for sending and receiving message
	protected abstract void sendMessage(Entity sender,Entity reciver,String text);
    protected abstract void reciveMessage(Entity sender,Entity reciver,String text);
}


