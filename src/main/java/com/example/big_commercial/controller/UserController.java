package com.example.big_commercial.controller;

import com.example.big_commercial.dto.UserDTO;
import com.example.big_commercial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = {"application/json"})
    public ResponseEntity<Page<UserDTO>> getPagingUsers(Pageable pageable){
        return new ResponseEntity<Page<UserDTO>>(userService.findPaging(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}", produces = {"application/json"})
    public ResponseEntity<Optional<UserDTO>> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users", produces = {"application/json"})
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/users/{id}", produces = {"application/json"})
    public ResponseEntity<UserDTO> update(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.update(id, userDTO), HttpStatus.OK);
    }
    @DeleteMapping(value = "/users/{id}", produces = {"application/json"})
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        userService.remove(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
