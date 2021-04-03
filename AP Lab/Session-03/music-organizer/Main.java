import java.util.ArrayList;

public class Main
{
    

    public static void main(String[] args) 
    {
        ArrayList<MusicCollection> categories = new ArrayList<MusicCollection>();

	    MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();

        categories.add(pop);
        categories.add(jazz);
        categories.add(rock);
        categories.add(country);

        Track t1 = new Track("aa", "bb", "2001");
        Track t2 = new Track("dd", "ee", "2002");
        Track t3 = new Track("gg", "hh", "2003");

        pop.addMusic(t1);
        pop.addMusic(t2);
        pop.addMusic(t3);

        pop.listAllTracks();

        System.out.println();

        pop.search("aa");

    }
}
