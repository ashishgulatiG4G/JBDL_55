package org.example.service;

import org.example.dto.GetUserResponse;
import org.example.models.User;
import org.json.simple.JSONObject;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService implements UserDetailsService {

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Function used by spring security to authenticate the user who is doing the transaction
     * Overridden to communicate and get the User object from User Service
     *
     * For inter service communication, txn user is used
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        // Actual API endpoint URL
        String url = "http://localhost:10000/user/username/" + username;

        // For inter service communication
        String transactionUser = "txn-service";
        String password = "test123";

        // Add credentials to the http header
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(transactionUser, password);

        // create http entity and add header to it
        HttpEntity<String> request = new HttpEntity<>(headers);

        // Get the response entity using Rest Template
        ResponseEntity<JSONObject> response = restTemplate.exchange(url, HttpMethod.GET, request, JSONObject.class);
        JSONObject responseBody = null;

        if (response.getStatusCode().is2xxSuccessful()) {
            responseBody = response.getBody();
        } else {
            throw new UsernameNotFoundException("Unable to authenticate user");
        }

        return User.builder()
                .username((String)responseBody.get("username"))
                .password((String)responseBody.get("password"))
                .authorities("usr")
                .build();

    }
}
