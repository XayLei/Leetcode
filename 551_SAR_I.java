public class Solution {
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
}

//利用正则表达式，这个方法，简直了...........