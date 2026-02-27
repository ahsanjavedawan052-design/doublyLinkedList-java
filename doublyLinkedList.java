class ListNode {
    int val;
    ListNode nextNode;
    ListNode prevNode;

    ListNode(int val) {
        this.val = val;
        this.nextNode = null;
        this.prevNode = null;
    }
}

public class DLLManager {
    
    // ===================== Show List using Iteration =======================
    static void showList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.nextNode;
        }
    }

    // ======================== Show List using Recursion ====================
    static void showRecursive(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        showRecursive(head.nextNode);
    }

    // ============================= Show Backward using Iteration ==========================
    static void showReverse(ListNode tail) {
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.prevNode;
        }
    }

    // ============================= Show Backward using Recursion ===========================
    static void showReverseRecursive(ListNode tail) {
        if (tail == null) {
            return;
        }
        System.out.print(tail.val + " ");
        showReverseRecursive(tail.prevNode);
    }

    // ================================== Add to Front ==========================================
    static ListNode addFirst(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        newNode.nextNode = head;
        if (head != null) {
            head.prevNode = newNode;
        }
        return newNode;
    }

    // ================================== Add to Tail ==========================================
    static void addLast(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = newNode;
            newNode.prevNode = temp;
        }
    }

    // ================================== Add at Index ===================================
    static void addAtIdx(ListNode head, int index, int data) {
        ListNode newNode = new ListNode(data);
        if (index == 1) {
            addFirst(head, data);
        } else if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            for (int i = 1; i < index - 1 && temp != null; i++) {
                temp = temp.nextNode;
            }
            if (temp == null) return;

            newNode.nextNode = temp.nextNode;
            newNode.prevNode = temp;
            if (temp.nextNode != null) {
                temp.nextNode.prevNode = newNode;
            }
            temp.nextNode = newNode;
        }
    }

    // ================================= Remove Head =====================================
    static ListNode removeFirst(ListNode head) {
        if (head == null) return null;
        head = head.nextNode;
        if (head != null) head.prevNode = null;
        return head;
    }

    // ================================= Remove Tail =====================================
    static ListNode removeLast(ListNode head) {
        if (head == null || head.nextNode == null) return null;
        
        ListNode temp = head;
        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        if (temp.prevNode != null) {
            temp.prevNode.nextNode = null;
        }
        return head;
    }

    // ================================= Remove at Index =====================================
    static ListNode removeAtIdx(ListNode head, int index) {
        if (head == null) return null;
        
        ListNode temp = head;
        for (int i = 1; i < index && temp != null; i++) {
            temp = temp.nextNode;
        }
        
        if (temp == null) return head;

        if (temp.prevNode != null)
            temp.prevNode.nextNode = temp.nextNode;

        if (temp.nextNode != null)
            temp.nextNode.prevNode = temp.prevNode;

        if (head == temp)
            head = temp.nextNode;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(40);
        ListNode second = new ListNode(50);
        ListNode third = new ListNode(60);

        head.nextNode = second;
        second.prevNode = head;
        second.nextNode = third;
        third.prevNode = second;

        System.out.println("Original List:");
        showList(head);
        System.out.println();

        System.out.println("Adding 10 and 20 at front:");
        head = addFirst(head, 20);
        head = addFirst(head, 10);
        showList(head);
        System.out.println();

        System.out.println("Adding 70 and 80 at end:");
        addLast(head, 70);
        addLast(head, 80);
        showList(head);
        System.out.println();

        System.out.println("Insert 30 at index 3:");
        addAtIdx(head, 3, 30);
        showList(head);
        System.out.println();

        System.out.println("Deleting first element:");
        head = removeFirst(head);
        showList(head);
        System.out.println();

        System.out.println("Deleting last element:");
        head = removeLast(head);
        showList(head);
        System.out.println();

        System.out.println("Deleting element at index 5:");
        head = removeAtIdx(head, 5);
        showList(head);
    }
}