package com.flcat.Dospital.domain.follow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Modifying // javax 의 트랜잭션, 서비스에서는 프레임워크
    @Query(value = "INSERT INTO follow(fromUserId, toUserId, createDate) VALUES(:fromUserId, :toUserId,now())", nativeQuery = true)
    int mFollow(Long fromUserId, Long toUserId); //prepareStatement updateQuery() => -1, 0, 1 응답의 결과 그래서 int로 받기

    @Modifying // javax 의 트랜잭션, 서비스에서는 프레임워크
    @Query(value = "DELETE FROM follow WHERE fromUserId = :fromUserId AND toUserId=:toUserId", nativeQuery = true)
    int mUnFollow(Long fromUserId, Long toUserId); //prepareStatement updateQuery() => -1, 0, 1 응답의 결과 그래서 int로 받기

    @Query(value = "SELECT count(*) FROM follow WHERE fromUserId = :principalId AND toUserId = :userId", nativeQuery = true)
    int mFollowState(Long principalId, Long userId);

    @Query(value = "SELECT count(*) FROM follow WHERE fromUserId = :userId", nativeQuery = true)
    int mFollowCount(Long userId);
}
