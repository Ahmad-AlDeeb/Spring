package org.horus.yogarestclient.controller;

import org.horus.yogarestclient.client.UserServiceClient;
import org.horus.yogarestclient.dto.User;
import org.horus.yogarestclient.util.APIResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserServiceClient userServiceClient;

    public UserController(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/{id}")
    public APIResponse<User> getUser(@PathVariable UUID id) {
        return userServiceClient.getUser(id);
    }

    @GetMapping
    public APIResponse<List<User>> getAllUsers() {
        return userServiceClient.getAllUsers();
    }

    @PostMapping
    public APIResponse<User> createUser(@RequestBody User user) {
        return userServiceClient.createUser(user);
    }

    @PutMapping("/{id}")
    public APIResponse<User> updateUser(@PathVariable UUID id, @RequestBody User user) {
        return userServiceClient.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public APIResponse<String> deleteUser(@PathVariable UUID id) {
        return userServiceClient.deleteUser(id);
    }
}
