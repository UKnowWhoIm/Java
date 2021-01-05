import java.util.Scanner;

class Node{
    int data;
    Node previous;
    Node next;
    
    Node(int data, Node previous, Node next){
        this.data = data;
        
        this.next = next;
        if(next != null)
            next.previous = this;
        
        this.previous = previous;
        if(previous != null)
            previous.next = this;
    }

    Node(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public void remove(){
        if(this.previous != null)
            this.previous.next = this.next;
        if(this.next != null)
            this.next.previous = this.previous;
    }
} 

class LinkedList{
    Node root;

    LinkedList(Node x){
        this.root = x;
    }

    LinkedList(){
        this.root = null;
    }

    void addElement(int data){
        if(this.root == null)
            this.root = new Node(data);
        else{
            Node i = this.root;
            for(; i.next != null; i=i.next);
            i.next = new Node(data, i, null);
        }
    }

    void traverse(){
        System.out.print("The elements are: ");
        for(Node i = this.root; i != null; i = i.next)
            System.out.printf("%d ", i.data);
        System.out.println();
    }

    void delete(int data){
        Node i = this.root;
        for(; i != null && i.data != data; i = i.next);

        if(i != null)
            i.remove();
        if(i == this.root)
            this.root = i.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        
        System.out.println("Enter elements: ");
        for(int i=0; i<n; i++){
            list.addElement(scanner.nextInt());
        }

        System.out.print("Enter element to be deleted: ");

        list.delete(scanner.nextInt());
        list.traverse();
        scanner.close();
    }
}
