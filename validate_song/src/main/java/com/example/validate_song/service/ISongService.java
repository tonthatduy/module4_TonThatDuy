package com.example.validate_song.service;

import com.example.validate_song.dto.SongRequestDto;
import com.example.validate_song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    void add(Song song);

    Song findById(Long id);
    void update(Long id, SongRequestDto songRequestDto);
}
