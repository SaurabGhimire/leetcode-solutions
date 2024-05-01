package utils.ListNode;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createListNodeFromArray(int[] arr){
        if(arr == null || arr.length == 0) return null;
        ListNode ans = new ListNode(arr[0]);
        for(int i=1;i<arr.length;i++){
            ListNode temp = ans;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new ListNode(arr[i]);
        }
        return ans;
    }

    public static void printListNode(ListNode root){
        while(root!= null){
            System.out.println(root.val);
            root = root.next;
        }
    }
}
