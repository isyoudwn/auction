package com.tasksprints.auction.domain.auction.service;

import com.tasksprints.auction.domain.auction.dto.AuctionDTO;
import com.tasksprints.auction.domain.auction.model.Auction;
import com.tasksprints.auction.domain.auction.model.AuctionStatus;
import com.tasksprints.auction.domain.auction.dto.AuctionRequest;

import java.util.List;

public interface AuctionService {
    AuctionDTO createAuction(Long userId, AuctionRequest.Create auctionRequest);

    void closeAuction(Long auctionId);
    String getAuctionStatus(Long auctionId);
    List<AuctionDTO> getAuctionsByUser(Long userId);
    List<AuctionDTO> getAllAuctions();
    AuctionDTO getAuctionById(Long auctionId);
}
