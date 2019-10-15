package com.stackroute.controller;

import com.stackroute.model.Music;
import com.stackroute.repository.MusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("api/v1")
    public class MusicController
    {
        @Autowired
        MusicRepo musicRepo;

        public MusicController(MusicRepo musicRepo) {
            this.musicRepo = musicRepo;
        }

        @PostMapping("/addSong")
        public ResponseEntity<?> saveMusic(@RequestBody Music song)
        {
            musicRepo.save(song);
            ResponseEntity responseEntity;
            try{
                responseEntity=new ResponseEntity<String>("Succesfull", HttpStatus.CREATED);
            }
            catch (Exception e)
            {
                responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            }
            return responseEntity;
        }
        @GetMapping("/getAllSongs")
        public ResponseEntity<?> getAllSongs()
        {
            return new  ResponseEntity<List<Music>>((List<Music>) musicRepo.findAll(),HttpStatus.OK);
        }
        @DeleteMapping("/delete/{trackId}")
        public String deleteUser(@PathVariable int trackId)
        {
            Music song = musicRepo.getOne(trackId);
           musicRepo.delete(song);
            return "deleted";
        }
        @PutMapping("updateSong")
        public ResponseEntity<?> updateSongDetail(@RequestBody Music song)
        {
            musicRepo.save(song);
            ResponseEntity responseEntity;
            try{
                responseEntity=new ResponseEntity<String>("Succesfull", HttpStatus.CREATED);
            }
            catch (Exception e)
            {
                responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            }
            return responseEntity;
        }
    }

