//�Ϸ�

package CoadingTest.KAKAOBLIND_2019;

import java.util.HashMap;
import java.util.LinkedList;

public class OpenChattingRoom_1 {

	public static void main(String[] args) {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result = solution(record);
		int index=0;

		for(int i=0; i<result.length; i++)
			System.out.println(result[i]);
	}

	static String[] solution(String[] record) {
		String[] answer, com;
		LinkedList<String> list = new LinkedList<String>();
		HashMap<String, String> id = new HashMap<>();
		int length = record.length;
		int count = length;
		
		for(int i=0; i<length; i++) {
			com = record[i].split(" ");
			
			if(com[0].equals("Enter")) {
				id.put(com[1], com[2]);
			}
			else if(com[0].equals("Change")) {
				count--;
				id.replace(com[1], id.get(com[1]), com[2]);
				continue;
			}
			list.add(com[0] + " " + com[1]);
		}
		
		length = list.size();
		answer = new String[length];
		
		for(int i=0; i<length; i++) {
			com = list.get(0).split(" ");
			list.remove(0);
			if(com[0].equals("Enter")) {
				answer[i] = id.get(com[1]) + "���� ���Խ��ϴ�.";
			}else {
				answer[i] = id.get(com[1]) + "���� �������ϴ�.";
			}
		}
		
        return answer;
	}
	
}
