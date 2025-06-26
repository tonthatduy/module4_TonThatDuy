package com.example.validate_song.service;

import com.example.validate_song.dto.SongRequestDto;
import com.example.validate_song.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.validate_song.repository.ISongRepository;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public void add(Song song) {
        songRepository.save(song);

    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, SongRequestDto songRequestDto) {
        Song song = songRepository.findById(id).orElse(null);
        song.setNameSong(songRequestDto.getNameSong());
        song.setSinger(songRequestDto.getSinger());
        song.setCategory(songRequestDto.getCategory());
        songRepository.save(song);
    }
}
