package com.fresco.tenderManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


@RequestMapping("/bidding")
public class BiddingController {

    
    private BiddingService biddingService;

    @PostMapping("/add")
    public ResponseEntity<Object> postBidding(@RequestBody BiddingModel biddingModel) {

        ResponseEntity<Object> postResult = biddingService.postBidding(biddingModel);
        return null;
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getBidding(@RequestParam double bidAmount) {
        return null;
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Object> updateBidding(@PathVariable int id, @RequestBody BiddingModel biddingModel) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBidding(@PathVariable int id) {
        return null;
    }
}
