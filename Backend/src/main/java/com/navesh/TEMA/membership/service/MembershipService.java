package com.navesh.TEMA.membership.service;

import com.navesh.TEMA.common.entity.Membership;
import com.navesh.TEMA.common.entity.User;
import com.navesh.TEMA.common.enums.MembershipStatus;
import com.navesh.TEMA.common.exception.BadRequestException;
import com.navesh.TEMA.common.exception.ResourceNotFoundException;
import com.navesh.TEMA.membership.dto.AddMembershipRequest;
import com.navesh.TEMA.membership.dto.UpdateMembershipRequest;
import com.navesh.TEMA.membership.repo.MembershipRepository;
import com.navesh.TEMA.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private UserRepository userRepository;

    public Membership addMembership(AddMembershipRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        int duration = request.getDurationMonths();

        if (duration != 6 && duration != 12 && duration != 24) {
            throw new BadRequestException("Duration must be 6, 12 or 24 months");
        }

        Membership membership = new Membership();
        membership.setUser(user);
        membership.setMembershipNumber(UUID.randomUUID().toString());
        membership.setStartDate(LocalDate.now());
        membership.setEndDate(LocalDate.now().plusMonths(duration));
        membership.setDurationMonths(duration);
        membership.setStatus(MembershipStatus.ACTIVE);

        return membershipRepository.save(membership);
    }

    public Membership updateMembership(UpdateMembershipRequest request) {

        Membership membership = membershipRepository
                .findByMembershipNumber(request.getMembershipNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Membership not found"));

        if (request.isCancel()) {
            membership.setStatus(MembershipStatus.CANCELLED);
        } else {
            int extend = request.getExtendMonths() == 0 ? 6 : request.getExtendMonths();
            membership.setEndDate(membership.getEndDate().plusMonths(extend));
            membership.setDurationMonths(
                    membership.getDurationMonths() + extend
            );
        }

        return membershipRepository.save(membership);
    }
}
