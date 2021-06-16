package priorityQueue;

public class MyEntry implements Entry{
	Object key;
	Object value;
	
	@Override
	public void setKey(Object k) {
		this.key = k;
	}

	@Override
	public void setValue(Object v) {
		this.value = v;
	}

	@Override
	public Object getKey() {
		return key;
	}

	@Override
	public Object getValue() {
		return value;
	}

}
