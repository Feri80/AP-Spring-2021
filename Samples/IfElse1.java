
public class IfElse1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        char gradeRank;
        float studentGrade = 17.0f;
        if (studentGrade >= 17) {
            gradeRank = 'A';
            System.out.println("Student Grade is A!");
        } else if (studentGrade >= 15) {
            gradeRank = 'B';
            System.out.println("Student Grade is B!");
        } else if (studentGrade >= 12) {
            gradeRank = 'C';
            System.out.println("Student Grade is C!");
        } else if (studentGrade >= 10) {
            gradeRank = 'D';
            System.out.println("Student Grade is D!");
        } else {
            System.out.println("Student Failed!");
        }

    }

}
