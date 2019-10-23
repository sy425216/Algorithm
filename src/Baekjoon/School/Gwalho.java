
package Baekjoon.School;

import java.util.Stack;

public class Gwalho {

	public static void main(String[] args) {
		
		String p = ")(()";
		
		System.out.println(solution(p));
		
	}
	
	static String solution(String p) {
		String result = p;
		int length=p.length(), countL=0, countR=0;
		boolean status = true;
		
		

		if(p.equals("") || p==null)
			return p;
		
		if(isCorrect(p))
			return p;
		
		for(int i=0; i<length; i++) {
			if(p.charAt(i)=='(')
				countL++;
			else if(p.charAt(i)==')')
				countR++;
		}
		
		if(countL != countR)
			return "�ȸ´´ٰ�";
		
		
		p = toCorrect(p);
		
		return p;
	}
	
	static String toCorrect(String w) {
		int countL=0, countR=0, length = w.length();
		String result = "";
		
		for(int i=0; i<length; i++) {
			if(w.charAt(i)=='(')
				countL++;
			else if(w.charAt(i)==')')
				countR++;
			
			if(countL==countR) {
				result = toCorrect(w.substring(0,i+1), w.substring(i+1));
				break;
			}
		}
		
		return result;
	}
	static String toCorrect(String u, String v) {
		String result="";
		int length=u.length();
		
		if(isCorrect(u)) {
			if(v.equals(""))
				return u+v;
			return u+toCorrect(v);
		}
		

		result += '(';
		result += toCorrect(v);
		result += ')';	
		
		for(int i=1; i<length-1; i++) {
			if(u.charAt(i)=='(')
				result+=')';
			else
				result+='(';
		}
		
		return result;
	}
	
	
	static boolean isCorrect(String p) {
		Stack<Character> stack = new Stack();
		int length = p.length();
		
		for(int i=0; i<length; i++) {
			if(p.charAt(i)=='('){
				stack.push('(');
			}
			else if(p.charAt(i)==')'){
				if(stack.isEmpty()==false && stack.peek()=='(')
					stack.pop();
				else
					return false;
			}
			else
				return false;
		}
		
		if(stack.isEmpty())
			return true;
		
		return false;
	}

}
