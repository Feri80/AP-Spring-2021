import java.util.ArrayList;
import java.util.Iterator;

public class IteratorVsForEach {

    public static void main(String[] args) {
        ArrayList<String> notes = new ArrayList<String>();

        notes.add("First object.");
        notes.add("Second object.");
        notes.add("Second object.");
        notes.add("Third object.");
        notes.add("Fourth object.");

        for (String note : notes) {
            System.out.println(note);
        }

//         Would this code segment run?
//        for (String note : notes) {
//            System.out.println(note);
//            if(note.contains("Second")) {
//                notes.remove("Second object.");
//            }
//        }
        
        Iterator<String> it = notes.iterator();
        while (it.hasNext()) {
            String note = it.next();
            if (note.contains("Second")) { //it.next().contains("Second")
                it.remove();
            }
        }
        
        System.out.println();
        
        for (String note : notes) {
            System.out.println(note);
        }
    }

}
