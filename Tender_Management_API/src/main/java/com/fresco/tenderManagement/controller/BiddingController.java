package com.fresco.tenderManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fresco.tenderManagement.model.BiddingModel;
import com.fresco.tenderManagement.service.BiddingService;


@RestController
@RequestMapping("/bidding")
public class BiddingController {

    @Autowired
    private BiddingService biddingService;

    @PostMapping("/add")
    public ResponseEntity<Object> postBidding(@AuthenticationPrincipal UserDetails user, @RequestBody BiddingModel biddingModel) {
        return biddingService.postBidding(user,biddingModel);
    }

    //    Go to the "Headers" tab in Postman.
//Add a new header:
//Key: Authorization
//Value: Bearer <your-jwt-token>
//Example: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiaWRkZXJlbWFpbEBnbWFpbC5jb20iLCJyb2xlcyI6W3siYXV0aG9yaXR5IjoiQklEREVSIn1dLCJleHAiOjE3Nzg1NzA4MDUsImlhdCI6MTc3ODU1MjgwNX0.Tr3op2wIrZeIPntk2nGHTA2bU-6eCMC3BLn0MKASjNnmH84UX30s_VmROT2oauOEv1QBQPyv5p8Zjs773rDM8A
    @GetMapping("/list")
    public ResponseEntity<Object> getBidding(@RequestParam double bidAmount) {
        return biddingService.getBidding(bidAmount);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Object> updateBidding(@AuthenticationPrincipal UserDetails details,@PathVariable int id, @RequestBody BiddingModel biddingModel) {
        return biddingService.updateBidding(details,id, biddingModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBidding(@PathVariable int id) {
        return biddingService.deleteBidding(id);
    }
}
