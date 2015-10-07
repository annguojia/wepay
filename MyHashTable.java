public class MyHashTable<K, V>{
// wepay code challenge
	private class KVpair {
		private K key;
		private V value;
		public KVpair(K key, V value) {
			this.key = key;
			this.value = value;
		}
		public void setK(K key) {
			this.key = key;
		}
		public void setV(V value) {
			this.value = value;
		}
		public K getKey() {
			return this.key;
		}
		public v getValue() {
			return this.value;
		}
 	}
	
	private static final int DEFAULT_CAPACITY = 200;
	private int capacity;
	private int size;
	private Object[] table;
	
	
	// constructor
	public MyHashTable() {
		capacity = DEFAULT_CAPACITY;
		this.table = new Object[DEFAULT_CAPACITY];
		for (int i = 0; i < DEFAULT_CAPACITY; i++) {
			table[i] = new LinkedList<KVPair>();
		}
		this.size = 0;
		
	}
	
	public int hash(K key) {
		return Math.abs(key.hashCode() % this.capacity);
	}
	
	public int getSize() {
		return this.size();
	}
	public int getCapacity() {
		return this.capacity;
	}
 	
	// put function
	public void put(K key V value) {
		int hash = hash(key);
		if (get(key) != null) {
			LinkedList<KVpair> temp = (LinkedList<KVpair>) table[hash];
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).getKey().equals(key)) {
					temp.get(i).setV(value);
				}
			}
		} else {
			KVpair toAdd = new KVpair(key, value);
			(LinkedList<KVpair>)table[hash].add(toAdd);
			this.size++;
		}
	}
	
	// get function
	public V get(K key) {
		int hash = hash(key);
		LinkedList<KVpair> cur = (LinkedList<KVpair>) table[hash];
		if (!cur.isEmpty()) {
			int s = cur.size();
			for (int i = 0; i < s; i++) {
				if (cur.get(i).getKey().equals(key)) {
					return cur.get(i).getValue();
				}
			}
		}else {
			return null；
		}
		
	}
	
	
	
}
