/*
�ڵ��׽�Ʈ ���� 2��
��������/�ùٸ� ��ȣ

1���� ����

�׽�Ʈ���̽� �Ϸ�
*/
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
		boolean status = true;	// true = �ùٸ� // false = ��������
		
		

		if(p.equals("") || p==null)	// �� ���ڿ��̸� return
			return p;
		
		if(isCorrect(p))			// �ùٸ� ���ڿ��̸�  return
			return p;
		
		for(int i=0; i<length; i++) {
			if(p.charAt(i)=='(')
				countL++;
			else if(p.charAt(i)==')')
				countR++;
		}
		
		if(countL != countR)		// Ʋ�����ڿ��̸� xxxxx
			return "�ȸ´´ٰ�";
		
		
		p = toCorrect(p);			// ��ġ��
		
		return p;
	}
	
	static String toCorrect(String w) {			//  ���ڿ� u v �� �����ֱ� 
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
	static String toCorrect(String u, String v) {	// u, v �ùٸ����� ��ġ��
		String result="";
		int length=u.length();
		
		if(isCorrect(u)) {			// u�� �ǹٸ� ���ڿ��̸� v�����ϰ� ���̱�
			if(v.equals(""))		// �ٵ� v�� ���ڿ��̸� �׳� return ����
				return u+v;
			return u+toCorrect(v);
		}
		
		
		// u�� �ǹٸ� ���ڿ��� �ƴϸ�
		result += '(';
		result += toCorrect(v);
		result += ')';	
		
		for(int i=1; i<length-1; i++) {	// ù��° ������ ���� ���� ��ȣ���� �ݴ�
			if(u.charAt(i)=='(')
				result+=')';
			else
				result+='(';
		}
		
		return result;
	}
	
	
	static boolean isCorrect(String p) {		// ���� ���ڿ����� üũ
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
