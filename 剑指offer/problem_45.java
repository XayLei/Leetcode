/*
“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
*/
public class Solution {
    public String ReverseSentence(String str) {
        if (str.trim().equals(""))
			return str;
		String[] s = str.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = s.length - 1; i > 0; i--) {
			sb.append(s[i]);
			sb.append(" ");
		}
		sb.append(s[0]);
		return sb.toString();
    }
}