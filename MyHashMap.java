class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    Node[] table;

    MyHashMap(){
        table = new Node[2048];   
    }

    public void put(int key, int value){
       if( table[hashCode(key)] == null){
            table[hashCode(key)] = new Node(value);
            return;
       }

       Node bucket = table[hashCode(key)];
       Node prev = bucket;
       while(bucket != null && bucket.key != key){
            prev = bucket;
            bucket = bucket.next;
       }

       if(bucket == null){
            prev.next = new Node(value);
       }else{
            bucket.val = value;
       }
    }

    public int get(int key){
        if(table[hashCode(key)] == null) return -1;

        Node bucket = table[hashCode(key)];

        while(bucket != null && bucket.key != key){
            bucket = bucket.next;
        }

        if(bucket == null){
            return -1;
        }else{
            return bucket.val;
        }
        
    }

    public void remove(int key){
        if(table[hashCode(key)] == null) return;

        Node bucket = table[hashCode(key)];

        if(bucket.key == key) {
            table[hashCode(key)] = bucket.next;
            return;
        }

        Node prev = bucket;
		
		while(bucket != null && bucket.key != key) {
			prev = bucket;
			bucket = bucket.next;
		}
		
		if(bucket != null) {
			
			prev.next = bucket.next;
			
		}
    }

    private int hashCode(int num){
        return num%2048;
    }

}
