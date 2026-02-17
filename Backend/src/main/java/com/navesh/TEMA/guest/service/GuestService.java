package com.navesh.TEMA.guest.service;

import com.navesh.TEMA.common.entity.Guest;
import com.navesh.TEMA.common.entity.User;
import com.navesh.TEMA.common.exception.ResourceNotFoundException;
import com.navesh.TEMA.guest.dto.GuestRequest;
import com.navesh.TEMA.guest.repository.GuestRepository;
import com.navesh.TEMA.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private UserRepository userRepository;

    public Guest addGuest(String email, GuestRequest request) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Guest g = new Guest();
        g.setUser(user);
        g.setGuestName(request.getGuestName());
        g.setContact(request.getContact());

        return guestRepository.save(g);
    }

    public List<Guest> getGuests(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return guestRepository.findByUser(user);
    }

    public Guest updateGuest(Long id, GuestRequest request) {

        Guest g = guestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found"));

        g.setGuestName(request.getGuestName());
        g.setContact(request.getContact());

        return guestRepository.save(g);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}
