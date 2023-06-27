import java.util.NoSuchElementException;
import java.lang.reflect.Array;
class SimpleLinkedList<T> {
    Node Head;
    Node Tail;
    class Node{
        T data;
        Node next;
        Node(T data){
            this.data = data ;
        }
    }
    SimpleLinkedList() {
       Head = null;
        Tail = null;
    }

    SimpleLinkedList(T[] values) {
        for (int index =0 ; index < values.length ; index++){
            push(values[index]);
        }
    }

    void push(T value) {
        Node n = new Node(value);
        if(Head == null){
            Head = n;
            Tail = n;
        }
        else{
            Tail.next = n;
            Tail = n;
        }
    }

   T pop() throws NoSuchElementException{
        Node temp = Head;
        T data;
        if(temp == null){
            throw new NoSuchElementException();
        }
        else if(isOneNode()){
            data = Tail.data;
            Head = temp = Tail = null ;
            }
        else{
        while(temp.next.next != null){
            temp = temp.next;
            }
        
        data = Tail.data;
        Tail = temp;
        Tail.next = null;
        }
        return data;
    }

    void reverse() {
          {
        Tail = Head ;
        Node prev = null;
        Node current = Head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Head = prev;
    }
    }

    T[] asArray(Class<T> clazz) {
      int size = this.size() ;
        T[] arr = (T[]) Array.newInstance(clazz, size);
        Node temp = Head;
        int i = 0;
        while(temp!= null){
            arr[i++] = temp.data;
            temp = temp.next;
        }
        T[] arr2 = (T[]) Array.newInstance(clazz, size);
        i =0 ;
        int length = size-1;
        while(length >= 0){
            arr2[length--] = arr[i++];
        }
     return arr2;
        /*int length = clazz.size();
        T [] arr = new T [length];
        for(int i =0 ; i < length ; i++){
            arr[i] = pop();
        }
        return arr;*/
    }

    int size() {
       int count = 0;
       if(Head == null)
           return count;
        else{
            count++;
            Node temp = Head;
            while(temp.next!= null){
                temp = temp.next;
                count++;
                
            }
            return count;
            
        }
    }
     boolean isOneNode(){
        return Head.next == null;
    }
}

    

