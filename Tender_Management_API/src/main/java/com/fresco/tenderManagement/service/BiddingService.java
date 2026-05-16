package com.fresco.tenderManagement.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fresco.tenderManagement.model.BiddingModel;
import com.fresco.tenderManagement.model.UserModel;
import com.fresco.tenderManagement.repository.BiddingRepository;
import com.fresco.tenderManagement.repository.UserRepository;

@Service
public class BiddingService {

    @Autowired
    private BiddingRepository biddingRepository;

    @Autowired
    private UserService userService;

    public ResponseEntity<Object> postBidding(UserDetails user, BiddingModel biddingModel) {
        UserModel userModel = userService.getUserByEmail(user.getUsername());

        if (!"BIDDER".equals(userModel.getRole().getRolename())) {
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);
        }
        biddingModel.setBidderId(userModel.getId());
        biddingModel.setDateOfBidding(getCurrentDate());
        biddingRepository.save(biddingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(biddingModel);

    }

    private String getCurrentDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    public ResponseEntity<Object> getBidding(double bidAmount) {
        List<BiddingModel> result = biddingRepository.findByBidAmountGreaterThan(bidAmount);
        if (result.isEmpty()){
            return new ResponseEntity<>("no data available", HttpStatus.BAD_REQUEST);

        }
    	return new ResponseEntity<>(result, HttpStatus.OK);

    }

    public ResponseEntity<Object> updateBidding(UserDetails user, int id, BiddingModel model) {
        BiddingModel bidding = biddingRepository.findById(id).orElse(null);
        if (bidding == null) {
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
        bidding.setStatus(model.getStatus());
        biddingRepository.save(bidding);

            return new ResponseEntity<>(bidding, HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteBidding(int id) {
            BiddingModel bidding = biddingRepository.findById(id).orElse(null);
            if (bidding == null) {
                return new ResponseEntity<>("Not found", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Deleted successfully",HttpStatus.NO_CONTENT);
    }
}
    
