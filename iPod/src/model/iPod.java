package model;

import model.media.AbstractMedia;
import model.media.Movie;
import model.media.Photo;
import model.media.Song;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class iPod implements Iterable<AbstractMedia> {

    private String name;
    private Set<AbstractMedia> movies = new HashSet<>();
    private Set<AbstractMedia> photos = new HashSet<>();
    private Collection<AbstractMedia> songs = new HashSet<>();


    public iPod(String name) {
        this.name = name;
    }

    // getters
    public String getName() { return name; }

    public void addMovie(Movie m) { movies.add(m); }
    public void addPhoto(Photo p) { photos.add(p); }
    public void addSong(Song s) { songs.add(s); }

    @Override
    public Iterator<AbstractMedia> iterator() {
        return new AbstractMediaIterator();
    }


    private class AbstractMediaIterator implements Iterator<AbstractMedia> {
        Iterator moviesIterator = movies.iterator();
        Iterator songsIterator = songs.iterator();
        Iterator photosIterator = photos.iterator();

        @Override
        public boolean hasNext() {
            return moviesIterator.hasNext() || songsIterator.hasNext() || photosIterator.hasNext();
        }

        @Override
        public AbstractMedia next() {
            AbstractMedia abstractMedia = null;
            if (moviesIterator.hasNext()){
                abstractMedia = (AbstractMedia) moviesIterator.next();
            } else if (songsIterator.hasNext()){
                abstractMedia = (AbstractMedia) songsIterator.next();
            } else {
                abstractMedia = (AbstractMedia) photosIterator.next();
            }
            return abstractMedia;
        }


    }
}