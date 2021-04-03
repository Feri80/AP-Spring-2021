import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the music files.
    private ArrayList<Track> tracks;
    // An ArrayList for storing the favorite music files
    private ArrayList<Track> favorites;
    // A player for the music files.
    private MusicPlayer player;

        
    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        tracks = new ArrayList<Track>();
        favorites = new ArrayList<Track>();
    }
    
    /**
     * Add a new music to the collection.
     * @param newMusic The music to be added.
     */
    public void addMusic(Track newMusic)
    {
        tracks.add(newMusic);
    }

    /**
     * Add a new music to the favorite collection.
     * @param newMusic The music to be added.
     */
    public void addFavorite(Track newMusic)
    {
        favorites.add(newMusic);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listTrack(int index)
    {
        System.out.println("Track Address : " + tracks.get(index).address);
        System.out.println("Track Artist : " + tracks.get(index).artist);
        System.out.println("Track Release Date : " + tracks.get(index).releaseDate);
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllTracks()
    {
        for(Track t : tracks)
        {
            System.out.println("Track Address : " + t.address);
            System.out.println("Track Artist : " + t.artist);
            System.out.println("Track Release Date : " + t.releaseDate);
            System.out.println();
        }
    }
    
    /**
     * Show a list of all the favorites in the collection.
     */
    public void listAllFavorites()
    {
        for(Track t : favorites)
        {
            System.out.println("Track Address : " + t.address);
            System.out.println("Track Artist : " + t.artist);
            System.out.println("Track Release Date : " + t.releaseDate);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeTrack(int index)
    {
        tracks.remove(index);
    }

    /**
     * Remove a file from the favorite collection.
     * @param index The index of the file to be removed.
     */
    public void removeFavorite(int index)
    {
        favorites.remove(index);
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String fileName = tracks.get(index).address;
        player.startPlaying(fileName);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Search a track with a key
     * @param key
     */
    public void search(String key)
    {
        for(Track t : tracks)
        {
            if(t.artist.equals(key) || t.address.equals(key))
            {
                System.out.println("Music Found!");
                System.out.println("Track Address : " + t.address);
                System.out.println("Track Artist : " + t.artist);
                System.out.println("Track Release Date : " + t.releaseDate);
                return;
            }
        }
        System.out.println("Music not found!");
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        if(index >= tracks.size())
        {
            System.out.println("Invalid!");
            return false;
        }
        return true;
    }
}