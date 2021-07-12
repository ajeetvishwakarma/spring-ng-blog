package com.blog.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.dto.PostDto;
import com.blog.security.PostService;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/upload/image/{id}")
    public ResponseEntity<PostDto> createPost(@RequestParam("imageFile") MultipartFile file,@PathVariable Long id) {
    	PostDto postDto= postService.createPostImage(file,id);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
    
    @PostMapping("/upload")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
    	 postDto= postService.createPost(postDto);
        return new  ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(postService.readSinglePost(id), HttpStatus.OK);
    }
    
    @DeleteMapping("/get/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(postService.deletePost(id), HttpStatus.OK);
    }
    
    
}
