package com.psw.servizi.repository;

import com.psw.servizi.model.Cake;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface CakeRepository extends JpaRepository<Cake, Long> {

    Page<Cake> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);


}
