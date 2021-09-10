public interface Deque <generic>{
    int size = 0;

    public void addFirst(generic item);
    public generic getRecursive(int index);
    public void addLast(generic item);

    public default boolean isEmpty(){
        if(size==0) return true;
        return false;
    }
    public default int size(){
        return size;
    }
    public void printDeque();
    public generic removeFirst();
    public generic removeLast();
    public generic get(int index);

}
