package de.msch.repository;

import de.msch.domain.Audiofile;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Audiofile entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AudiofileRepository extends JpaRepository<Audiofile, Long> {}
