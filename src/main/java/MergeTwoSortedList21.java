import ListNode.ListNode;

public class MergeTwoSortedList21 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {1,3,4};
        ListNode list1 = ListNode.createListNodeFromArray(arr1);
        ListNode.printListNode(list1);

        ListNode list2 = ListNode.createListNodeFromArray(arr2);
        ListNode.printListNode(list2);

        ListNode ans = mergeTwoLists(list1, list2);
        ListNode.printListNode(ans);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        return ans;
    }
}
