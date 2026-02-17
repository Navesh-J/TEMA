package com.navesh.TEMA.guest.controller;

import com.navesh.TEMA.common.entity.Guest;
import com.navesh.TEMA.common.response.ApiResponse;
import com.navesh.TEMA.guest.dto.GuestRequest;
import com.navesh.TEMA.guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/guests")
@CrossOrigin(origins = "*")

public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping
    public ApiResponse<Guest> addGuest(Authentication auth, @RequestBody GuestRequest request) {

        return ApiResponse.success("Guest added", guestService.addGuest(auth.getName(), request));
    }

    @GetMapping
    public ApiResponse<List<Guest>> getGuests(Authentication auth) {

        return ApiResponse.success("Guest list fetched", guestService.getGuests(auth.getName()));
    }

    @PutMapping("/{id}")
    public ApiResponse<Guest> updateGuest(@PathVariable Long id, @RequestBody GuestRequest request) {

        return ApiResponse.success("Guest updated", guestService.updateGuest(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteGuest(@PathVariable Long id) {

        guestService.deleteGuest(id);

        return ApiResponse.success("Guest deleted", null);
    }
}
