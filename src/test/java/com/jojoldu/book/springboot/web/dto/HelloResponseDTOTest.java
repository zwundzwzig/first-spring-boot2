package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDTOTest {

  @Test
  public void lombokUnitTest() {
    //given
    String name = "test";
    int amount = 1000;

    //when
    HelloResponseDTO dto = new HelloResponseDTO(name, amount);

    assertThat(dto.getName()).isEqualTo(name);
    assertThat(dto.getAmount()).isEqualTo(amount);
  }
}
