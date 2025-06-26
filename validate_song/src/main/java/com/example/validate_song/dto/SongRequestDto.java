package com.example.validate_song.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongRequestDto implements Validator {
    private String nameSong;
    private String singer;
    private String category;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongRequestDto songRequestDto = (SongRequestDto) target;
        //check SongName
        if (songRequestDto.getNameSong() == null || songRequestDto.getNameSong().trim().isEmpty()) {
            errors.rejectValue("nameSong", null, "Không được để trống");
        } else if (songRequestDto.getNameSong().length() > 800) {
            errors.rejectValue("nameSong", null, "Không được dài quá 800 kí tự");
        } else if (!songRequestDto.getNameSong().matches("^[a-zA-Z0-9À-ỹ\\s']{1,800}$")) {
            errors.rejectValue("nameSong",null,"Tên Bài hát không được chứa kí tự đặc biệt");
        }
        //checkSinger
        if (songRequestDto.getSinger() == null || songRequestDto.getSinger().trim().isEmpty()) {
            errors.rejectValue("singer", null, "Không được để trống");
        } else if (songRequestDto.getSinger().length() > 800) {
            errors.rejectValue("singer", null, "Không được dài quá 800 kí tự");
        } else if (!songRequestDto.getSinger().matches("^[a-zA-Z0-9À-ỹ\\s']{1,800}$")) {
            errors.rejectValue("singer",null,"Tên Nghệ Sĩ không được chứa kí tự đặc biệt");
        }
        //checkCategory
        if (songRequestDto.getCategory() == null || songRequestDto.getCategory().trim().isEmpty()) {
            errors.rejectValue("category", null, "Không được để trống");
        } else if (songRequestDto.getCategory().length() > 1000) {
            errors.rejectValue("category", null, "Không được dài quá 1000 kí tự");
        } else if (!songRequestDto.getCategory().matches("^[a-zA-Z0-9À-ỹ\\s,]{1,1000}$")) {
            errors.rejectValue("category",null,"Tên thể loại không được chứa kí tự đặc biệt");
        }


    }
}
