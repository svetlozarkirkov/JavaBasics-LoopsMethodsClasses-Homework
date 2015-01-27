import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Problem14_ExamScore {
	
	public static class Student{
		private String name;
		private int examScore;
		private BigDecimal grade;
		
		public Student(String name, int examScore, BigDecimal grade){
			this.name=name;
			this.examScore=examScore;
			this.grade=grade;
		}
		public String getName(){
			return name;
		}
		public int getScore(){
			return examScore;
		}
		public BigDecimal getGrade(){
			return grade;
		}

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 3; i++){
			input.nextLine();
		}
		ArrayList<Student> students = new ArrayList<Student>();
		while (true) {
			String[] tempInput = input.nextLine().split("\\s*\\|\\s*");
			if (tempInput.length<4){
				break;
			}
			else{
				Student temp = new Student(tempInput[1],Integer.parseInt(tempInput[2]),new BigDecimal(tempInput[3]));
				students.add(temp);
			}
		}
		Collections.sort(students, new Comparator<Student>() {
			   public int compare(Student b1, Student b2) {
			      if (b1.getScore()<b2.getScore()){
			    	  return -1;
			      }
			      else if (b1.getScore()>b2.getScore()){
			    	  return 1;
			      }
			      else{
			    	  return 0;
			      }
			   }
			});
		ArrayList<Integer> distinctScores = new ArrayList<Integer>();
		for (int i = 0; i < students.size(); i++){
			if (!distinctScores.contains(students.get(i).getScore())){
				distinctScores.add(students.get(i).getScore());
			}
		}
		for (int i = 0; i < distinctScores.size(); i++){
			System.out.print(distinctScores.get(i)+" -> [");
			BigDecimal total = new BigDecimal("0");
			BigDecimal count = new BigDecimal("0");
			int stCount = 0;
			ArrayList<String> names = new ArrayList<String>();
			for (int j = 0; j < students.size(); j++){
				if (students.get(j).getScore()==distinctScores.get(i)){
					count = count.add(new BigDecimal("1"));
					stCount++;
					total = total.add(students.get(j).getGrade());
					names.add(students.get(j).getName());
				}
			}
			Collections.sort(names);
			for (int x = 0; x < names.size(); x++){
				System.out.print(names.get(x));
				if (stCount > 1){
					System.out.print(", ");
					stCount--;
				}
				else {
					System.out.printf("]; avg=%.2f\n",(total.divide(count,2,RoundingMode.HALF_UP)));
				}
			}
			
		}
		input.close();
	}
}