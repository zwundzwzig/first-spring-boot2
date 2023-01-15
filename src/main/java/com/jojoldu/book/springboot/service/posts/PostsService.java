package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsListResponseDTO;
import com.jojoldu.book.springboot.web.dto.PostsResponseDTO;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDTO;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDTO requestDTO) {
    return postsRepository.save(requestDTO.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDTO postsUpdateRequestDto) {
    Posts posts = postsRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("해당 게사글이 없습니다. id = " + id));
    posts.update(postsUpdateRequestDto.getTitle(), postsUpdateRequestDto.getContent());

    return id;
  }

  public PostsResponseDTO findById(Long id) {
    Posts entity = postsRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

    return new PostsResponseDTO(entity);
  }

  @Transactional
  public List<PostsListResponseDTO> findAllDesc() {
    return postsRepository.findAllDesc()
            .stream()
            .map(PostsListResponseDTO::new)
            .collect(Collectors.toList());
  }

  @Transactional
  public void delete (Long id) {
    Posts posts = postsRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

    postsRepository.delete(posts);
  }

}
