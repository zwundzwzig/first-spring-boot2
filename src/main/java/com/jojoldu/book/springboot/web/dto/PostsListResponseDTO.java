package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDTO {
  private Long id;
  private String title;
  private String author;
  private LocalDateTime modified_date;

  public PostsListResponseDTO(Posts entity) {
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.author = entity.getAuthor();
    this.modified_date = entity.getModified_date();
  }
}