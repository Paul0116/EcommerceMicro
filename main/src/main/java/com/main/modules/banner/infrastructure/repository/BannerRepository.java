package com.main.modules.banner.infrastructure.repository;

import com.main.modules.banner.domain.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

    Optional<Banner> findByTitle(String title);
}
