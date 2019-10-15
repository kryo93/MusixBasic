package com.stackroute.repository;

import com.stackroute.model.Music;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepo extends CrudRepository<Music, Integer> {
 Music getOne(int trackId);
}
