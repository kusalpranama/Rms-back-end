package edu.icet.controller;

import edu.icet.model.Admin;
import edu.icet.model.Customer;
import edu.icet.model.LoginRequest;
import edu.icet.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/Admin")
public class AdminController {

    private final AdminService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Admin admin = service.searchAdminEmail(loginRequest.getEmail());

            if (admin != null && admin.getPassword().equals(loginRequest.getPassword())) {
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("admin", admin);
                return ResponseEntity.ok(response);
            }

            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Invalid credentials"
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Login failed"
            ));
        }
    }



}
