package com.spj.booksms.dao;

import com.spj.booksms.model.Hotrecommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotrecommendDao extends JpaRepository<Hotrecommend, String> {
}
