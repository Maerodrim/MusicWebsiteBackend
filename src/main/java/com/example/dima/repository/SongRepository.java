package com.example.dima.repository;

import com.example.dima.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name = "Song")
public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> findByAlbumAfter(String str);

    List<Song> findByAuthorAfter(String str);

    List<Song> findByNameAfter(String str);

    List<Song> findByNameAndAlbumAndAuthor(String name, String author, String album);
}
