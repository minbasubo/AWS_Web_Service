package com.AWS_Web_Service.admin.dto;

import com.AWS_Web_Service.admin.web.dto.HelloResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Getter
@RequiredArgsConstructor
public class HelloResponseDtoTest {

    @Test
    public void LombokFuncTest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}

