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


public class BiddingService {


    
    private BiddingRepository biddingRepository;

    
    private UserService userService;

    public ResponseEntity<Object> postBidding(BiddingModel biddingModel) {
        biddingRepository.save(biddingModel);
        return null;
    }

    public ResponseEntity<Object> getBidding(double bidAmount) {
    	return null;

    }

    public ResponseEntity<Object> updateBidding(int id, BiddingModel model) {
        
            return null;
    }

    public ResponseEntity<Object> deleteBidding(int id) {
        
            return null;
    }
}
    
