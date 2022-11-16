import 'dart:math';

class ListNode {
  int val;
  ListNode? next;
  ListNode([this.val = 0, this.next]);
}

class Solution {
  ListNode? addTwoNumbers(ListNode? l1, ListNode? l2) {
    List<int> a = listFromListNode(l1);
    List<int> b = listFromListNode(l2);
    a = addTrailingZeros(a, b)[0];
    b = addTrailingZeros(a, b)[1];

    int carryOver = 0;
    List<int> sumList = [];
    for (int i = 0; i < max(a.length, b.length); i++) {
      sumList.add((a[i] + b[i] + carryOver) % 10);
      if ((a[i] + b[i] + carryOver) > 9) {
        carryOver = 1;
      } else {
        carryOver = 0;
      }
    }
    if (carryOver > 0) {
      sumList.add(1);
    }
    return listNodefromList(sumList.reversed.toList());
  }

  ListNode listNodefromList(List<int> numList) {
    ListNode? ans;
    for (int i = 0; i < numList.length; i++) {
      ListNode? tempListNode = ans;
      ans = ListNode(numList[i], tempListNode);
    }
    return ans ?? ListNode();
  }

  List<int> listFromListNode(ListNode? l) {
    List<int> numList = [];
    ListNode? tempListNode = l;
    do {
      numList.insert(0, tempListNode!.val);
      tempListNode = tempListNode.next;
    } while (tempListNode != null);
    return numList.reversed.toList();
  }

  List<List<int>> addTrailingZeros(List<int> a, List<int> b) {
    if (a.length > b.length) {
      b.addAll(List.generate(a.length - b.length, (index) => 0));
    } else if (a.length < b.length) {
      a.addAll(List.generate(b.length - a.length, (index) => 0));
    }
    return [a, b];
  }
}

void main() {
  Solution().addTwoNumbers(
    ListNode(
      2,
      ListNode(
        4,
        ListNode(3, ListNode(5)),
      ),
    ),
    ListNode(
      5,
      ListNode(
        6,
        ListNode(4),
      ),
    ),
  );
}
