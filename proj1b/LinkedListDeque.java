public class LinkedListDeque<generic> implements Deque<generic>{
    int size;
    public IntList sentinel;

    public class IntList{
        public generic value;
        public IntList next;
        public IntList prev;
        public IntList(){
            Integer temp=-999;
            value=(generic) temp;
            next=null;
            prev=null;
        }
        public IntList(generic value,IntList next,IntList prev){
            this.value=value;
            this.next=next;
            this.prev=prev;
        }
        public IntList(generic value){
            this.value=value;
            next=null;
            prev=null;
        }
//            public void add(generic value){
//            next =new IntList(value,this,null);
//        }

    }

    public IntList getFirstNode(){
        return sentinel.next;
    }
    public IntList getLastNode(){
        return sentinel.prev;
    }
    public LinkedListDeque(){
        Integer defaultValue=-999;
        size=0;
        IntList firstNode=new IntList();
        IntList lastNode=new IntList();
        firstNode.next=lastNode;
        lastNode.prev=firstNode;
        sentinel =new IntList((generic) defaultValue,firstNode,lastNode);
    }

    public LinkedListDeque(LinkedListDeque other){
        LinkedListDeque ans=new LinkedListDeque();
        int sizeOfOther=other.size();
        IntList pointer=other.getFirstNode();
        while(sizeOfOther>=0){
            pointer=pointer.next;
            sizeOfOther--;
            addLast(pointer.value);
        }
    }


    @Override
    public void addFirst(generic item) {
        size++;
        IntList temp=new IntList(item);
        temp.next=getFirstNode().next;
        getFirstNode().next.prev=temp;
        getFirstNode().next=temp;
        temp.prev=getFirstNode();
    }

    @Override
    public generic getRecursive(int index) {
        if(size<index+1) return null;
        return getRecursive(0,index,getFirstNode().next);
    }

    private generic getRecursive(int pos,int index,IntList x){
        if(pos==index) return x.value;
        return getRecursive(pos+1,index,x.next);
    }

    @Override
    public void addLast(generic item) {
        size++;
        IntList temp=new IntList((item));
        temp.next=getLastNode();
        temp.prev=getLastNode().prev;
        getLastNode().prev.next=temp;
        getLastNode().prev=temp;
    }

    @Override
    public void printDeque() {
        IntList beginning=getFirstNode().next;
        int toPrintSize=size;
        while(toPrintSize>0){
            if(toPrintSize!=1){
                System.out.print(beginning.value);
                toPrintSize--;
                beginning=beginning.next;
            }
            else {
                System.out.println(beginning.value);
                toPrintSize--;
            }
        }
    }

    @Override
    public generic removeFirst() {
        if(size==0) return null;
        else {
            size--;
            IntList toRemove=getFirstNode().next;
            getFirstNode().next=toRemove.next;
            toRemove.next.prev=getFirstNode();
            return toRemove.value;
        }
    }

    @Override
    public generic removeLast() {
        if(size==0) return null;
        else {
            size--;
            IntList toRemove=getLastNode().prev;
            getLastNode().prev=toRemove.prev;
            toRemove.prev.next=getLastNode();
            return toRemove.value;
        }
    }

    @Override
    public generic get(int index) {
        if(size<index+1) return null;
            // todo
        else {
            IntList iterator=getFirstNode().next;
            while(index>0){
                iterator=iterator.next;
                index--;
            }
            return iterator.value;
        }
    }
    }

