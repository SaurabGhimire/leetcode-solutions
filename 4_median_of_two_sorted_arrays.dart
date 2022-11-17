class Solution {
  String makeGood(String s) {
    List<String> sList = s.split('');
    List<String> ans = [];
    if (sList.length <= 1) {
      return sList.join();
    }
    ans.add(sList[0]);
    for (int i = 1; i < sList.length; i++) {
      if (ans.length > 0) {
        if (isSameAndDifferentCase(sList[i], ans.last)) {
          ans.removeLast();
        } else {
          ans.add(s[i]);
        }
      } else {
        ans.add(s[i]);
      }
    }
    return sList.join();
  }

  isSameAndDifferentCase(String a, String b) {
    if ((a.codeUnitAt(0) - b.codeUnitAt(0)).abs() == 32) {
      return true;
    }
    return false;
  }
}

void main() {
  Solution().makeGood("abBAcC");
}
