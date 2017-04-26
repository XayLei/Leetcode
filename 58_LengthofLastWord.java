public class Solution{
	public int lengthOfLastWord(String s){
		//返回一个字符串中最后一个单词的长度，String.lastIndexOf()返回最后一个空格处的索引
		return s.trim().length()-s.trim().lastIndexOf(' ')-1;
	}
}