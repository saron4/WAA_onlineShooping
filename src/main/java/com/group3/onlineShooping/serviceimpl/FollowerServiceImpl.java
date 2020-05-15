package com.group3.onlineShooping.serviceimpl;

import com.group3.onlineShooping.domain.Follower;
import com.group3.onlineShooping.domain.Seller;
import com.group3.onlineShooping.repository.FollowerRepository;
import com.group3.onlineShooping.service.FollowerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FollowerServiceImpl implements FollowerService {
    private FollowerRepository followerRepository;

    public FollowerServiceImpl(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Override
    public List<Follower> findAll() {
        return (List<Follower>) followerRepository.findAll();
    }

    @Override
    public Follower save(Follower follower) {
        return followerRepository.save(follower);
    }

    @Override
    public Follower find(Long id) {
        return followerRepository.findById(id).get();
    }

    @Override
    public Follower put(Follower follower) {
        return followerRepository.save(follower);
    }

    @Override
    public void delete(Follower follower) {
        followerRepository.delete(follower);
    }

    @Override
    public List<Seller> findAllBySeller(Long Id) {
        return followerRepository.findAllBySeller(Id);
    }

    @Override
    public List<Seller> findAllByProductAndReviewStatus(Follower.FollowerStatus followerStatus, Long id) {
        return followerRepository.findAllByProductAndReviewStatus(followerStatus,id);
    }

    @Override
    public Follower findFollowerByBuyerAndAndSeller(Long sellerId, Long buyerId) {
        return followerRepository.findFollowerByBuyerAndAndSeller(sellerId,buyerId);
    }
}
