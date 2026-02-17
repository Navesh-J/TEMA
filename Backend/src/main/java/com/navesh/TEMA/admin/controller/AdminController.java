package com.navesh.TEMA.admin.controller;

import com.navesh.TEMA.admin.dto.AddUserRequest;
import com.navesh.TEMA.admin.dto.UpdateUserRequest;
import com.navesh.TEMA.admin.service.AdminService;
import com.navesh.TEMA.common.entity.User;
import com.navesh.TEMA.common.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")

public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/users")
    public ApiResponse<User> addUser(
            @RequestBody AddUserRequest request) {

        return ApiResponse.success(
                "User added successfully",
                adminService.addUser(request)
        );
    }

    @PutMapping("/users/{id}")
    public ApiResponse<User> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request) {

        return ApiResponse.success(
                "User updated successfully",
                adminService.updateUser(id, request)
        );
    }
}
