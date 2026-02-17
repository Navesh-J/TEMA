package com.navesh.TEMA.membership.controller;

import com.navesh.TEMA.common.entity.Membership;
import com.navesh.TEMA.common.response.ApiResponse;
import com.navesh.TEMA.membership.dto.AddMembershipRequest;
import com.navesh.TEMA.membership.dto.UpdateMembershipRequest;
import com.navesh.TEMA.membership.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/memberships")
@CrossOrigin(origins = "*")

public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public ApiResponse<Membership> addMembership(
            @RequestBody AddMembershipRequest request) {

        return ApiResponse.success(
                "Membership added successfully",
                membershipService.addMembership(request)
        );
    }

    @PutMapping
    public ApiResponse<Membership> updateMembership(
            @RequestBody UpdateMembershipRequest request) {

        return ApiResponse.success(
                "Membership updated successfully",
                membershipService.updateMembership(request)
        );
    }
}
