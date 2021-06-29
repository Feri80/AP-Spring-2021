
public class IfElse2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        char gradeRank;
        float studentGrade = 18.0f;
        if (studentGrade >= 17) {
            gradeRank = 'A';
        } else if (studentGrade >= 15) {
            gradeRank = 'B';
        } else if (studentGrade >= 12) {
            gradeRank = 'C';
        } else if (studentGrade >= 10) {
            gradeRank = 'D';
        } else {
            gradeRank = 'F';
        }
        System.out.println("Student's grade is " + gradeRank + "!");

    }

}
