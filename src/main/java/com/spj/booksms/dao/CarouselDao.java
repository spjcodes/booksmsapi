package com.spj.booksms.dao;

import com.spj.booksms.model.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarouselDao extends JpaRepository<Carousel, String> {
}
