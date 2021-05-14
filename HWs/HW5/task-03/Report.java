public class Report 
{
    private String title;
    private String text;
    
    public Report(String title, String text)
    {
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString() 
    {
        return "--------------------------------------\n" + 
               "Title : " + 
               title + 
               "\nText : " + 
               text + 
               "\n--------------------------------------";    
    }
}
