package com.example.validate_form.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto implements Validator {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRequestDto userRequestDto = (UserRequestDto) target;
        // check first name
        if (userRequestDto.getFirstName() == null || userRequestDto.getFirstName().trim().isEmpty()) {
            errors.rejectValue("firstName", null, "Không được để trống");
        } else if (userRequestDto.getFirstName().length() < 5 || userRequestDto.getFirstName().length() > 45) {
            errors.rejectValue("firstName", null, "Tối thiếu 5 kí tự và tối đa 45 kí tự");
        }
        // check lastname
        if (userRequestDto.getLastName() == null || userRequestDto.getLastName().trim().isEmpty()) {
            errors.rejectValue("lastName", null, "Không được để trống");
        } else if (userRequestDto.getLastName().length() < 5 || userRequestDto.getLastName().length() > 45) {
            errors.rejectValue("lastName", null, "Tối thiếu 5 kí tự và tối đa 45 kí tự");
        }

        //check phoneNumber
        if (userRequestDto.getPhoneNumber().trim().isEmpty()) {
            errors.rejectValue("phoneNumber", null, "không được để trống");
        } else if (userRequestDto.getPhoneNumber().length() > 11 || userRequestDto.getPhoneNumber().length() < 10) {
            errors.rejectValue("phoneNumber", null, "Độ dài 10 số hoặc 11");
        } else if (!userRequestDto.getPhoneNumber().startsWith("0")) {
            errors.rejectValue("phoneNumber", null, "Số phải bắt đầu là số 0");
        } else if (!userRequestDto.getPhoneNumber().matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumber", null, "Phải đúng định dạng là số");
        }
        //check age
        if (userRequestDto.getAge() < 18) {
            errors.rejectValue("age", null, "Tuổi phải từ 18 trở lên");
        }
        //check email
        if (userRequestDto.getEmail() == null || userRequestDto.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", null, "Không được để trống");
        } else if (!userRequestDto.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            errors.rejectValue("email", null, "Chưa đúng định dạng");


        }
    }
}
