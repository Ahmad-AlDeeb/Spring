package org.horus.yogarestclient.client;

import org.horus.yogarestclient.dto.User;
import org.horus.yogarestclient.util.APIResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceClient {
    private final RestClient restClient;

    public UserServiceClient() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    public APIResponse<User> getUser(UUID id) {
        return restClient.get()
                .uri("/api/v1/users/{id}", id)
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

    public APIResponse<List<User>> getAllUsers() {
        return restClient.get()
                .uri("/api/v1/users/")
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }


    public APIResponse<User> createUser(User user) {
        return restClient.post()
                .uri("/api/v1/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .body(user)  // user data coming form the body of the request
                .retrieve()
                .body(new ParameterizedTypeReference<>(){}); // return type
    }

    public APIResponse<User> updateUser(UUID id, User user) {
        return restClient.put()
                .uri("/api/v1/users/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(user)
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }


    public APIResponse<String> deleteUser(UUID id) {
        return restClient.delete()
                .uri("api/v1/users/{id}", id)
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }
}
