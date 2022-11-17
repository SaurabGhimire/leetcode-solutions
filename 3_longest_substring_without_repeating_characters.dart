class Solution {
  int lengthOfLongestSubstring(String s) {
    List<String> subString = [];
    List<int> countList = [];

    for (int i = 0; i < s.length; i++) {
      if (!subString.contains(s[i])) {
        subString.add(s[i]);
        countList.add(subString.length);
      } else {
        subString.removeRange(0, subString.indexOf(s[i]) + 1);
        subString.add(s[i]);
        countList.add(subString.length);
      }
    }
    countList.sort();

    return countList.isNotEmpty ? countList.last : 0;
  }
}

void main() {
  Solution().lengthOfLongestSubstring('pwwkew');
}
